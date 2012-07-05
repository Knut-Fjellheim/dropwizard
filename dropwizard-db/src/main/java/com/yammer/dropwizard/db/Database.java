package com.yammer.dropwizard.db;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.yammer.dropwizard.db.args.OptionalArgumentFactory;
import com.yammer.dropwizard.db.logging.LogbackLog;
import com.yammer.dropwizard.db.validation.SchemaValidationException;
import com.yammer.dropwizard.db.validation.SchemaValidator;
import com.yammer.dropwizard.db.validation.SqlRequires;
import com.yammer.dropwizard.lifecycle.Managed;
import com.yammer.metrics.Metrics;
import com.yammer.metrics.jdbi.InstrumentedTimingCollector;
import org.apache.tomcat.dbcp.pool.ObjectPool;
import org.skife.jdbi.v2.ColonPrefixNamedParamStatementRewriter;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.lang.annotation.Annotation;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class Database extends DBI implements Managed {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Database.class);

    private final ObjectPool pool;
    private final String validationQuery;

    // TODO: reduce coupling
    private final SchemaValidator validator = new SchemaValidator(this);

    public Database(DataSource dataSource, ObjectPool pool, String validationQuery) {
        super(dataSource);
        this.pool = pool;
        this.validationQuery = validationQuery;
        setSQLLog(new LogbackLog(LOGGER, Level.TRACE));
        setTimingCollector(new InstrumentedTimingCollector(Metrics.defaultRegistry()));
        setStatementRewriter(new NamePrependingStatementRewriter(new ColonPrefixNamedParamStatementRewriter()));
        registerArgumentFactory(new OptionalArgumentFactory());
        registerContainerFactory(new ImmutableListContainerFactory());
    }

    @Override
    public void start() throws Exception {
        // already started, man
    }

    @Override
    public void stop() throws Exception {
        pool.close();
    }

    public void ping() throws SQLException {
        final Handle handle = open();
        try {
            handle.execute(validationQuery);
        } finally {
            handle.close();
        }
    }

    public <SqlObjectType> SqlObjectType onDemand(Class<SqlObjectType> sqlObjectType) {
        try {
            validate(sqlObjectType);
        } catch (SchemaValidationException e) {
            throw new RuntimeException(e);
        }

        return super.onDemand(sqlObjectType);
    }

    public <SqlObjectType> void validate(Class<SqlObjectType> sqlObjectType) throws SchemaValidationException {
        if (sqlObjectType.isAnnotationPresent(SqlRequires.class)) {
            ImmutableList<String> errors = validator.validate(sqlObjectType);

            if (!errors.isEmpty()) {
                throw new SchemaValidationException(sqlObjectType, errors);
            }
        }
    }
}
