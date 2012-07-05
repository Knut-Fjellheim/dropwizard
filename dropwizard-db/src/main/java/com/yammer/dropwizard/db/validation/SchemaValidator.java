package com.yammer.dropwizard.db.validation;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import java.lang.annotation.Annotation;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 * Validates SQL schame constraints.
 */
public class SchemaValidator {

    private DBI db;
    private SchemaMapping mapping;

    public SchemaValidator(DBI db) {
        this(db, SchemaMapping.defaults());
    }

    public SchemaValidator(DBI db, SchemaMapping mapping) {
        this.db = db;
        this.mapping = mapping;
    }

    public <T> ImmutableList<String> validate(Class<T> o) {
        final Set<String> errors = Sets.newHashSet();
        final Handle handle = db.open();
        try {
            final DatabaseMetaData metaData = handle.getConnection().getMetaData();
            for (Annotation annotation : o.getAnnotations()) {
                if (annotation instanceof SqlRequires) {
                    SqlRequires validation = (SqlRequires) annotation;
                    ResultSet columns = metaData.getColumns(null, null, validation.table(), validation.field());
                    while (columns.next()) {
                        if (!mapping.isMarshallable(columns.getInt("DATA_TYPE"), validation.type())) {
                            errors.add(String.format("'%s' in table '%s' must be marshallable as a '%s' (was a '%s')",
                                                     validation.field(),
                                                     validation.table(),
                                                     validation.type(),
                                                     columns.getString("TYPE_NAME")));
                        }
                    }
                }
            }

            return ImmutableList.copyOf(Ordering.natural().sortedCopy(errors));

        } catch (SQLException e) {
            throw new RuntimeException("Failed to validate database schema", e);
        } finally {
            handle.close();
        }
    }
}
