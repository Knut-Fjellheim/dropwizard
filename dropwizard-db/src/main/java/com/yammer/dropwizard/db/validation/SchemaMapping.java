package com.yammer.dropwizard.db.validation;

import com.google.common.collect.ImmutableSet;

import java.math.BigInteger;
import java.sql.Types;
import java.util.Set;

/**
 * A mapping of SQL types to Java types.
 *
 * TODO: ditch this in favour of whatever JDBI uses internally
 */
public class SchemaMapping {

    private Set<Class<?>>[] types;

    public SchemaMapping(Set<Class<?>>[] types) {
        this.types = types;
    }

    public boolean isMarshallable(int fromType, Class<?> toType) {
        return (types[fromType] != null && types[fromType].contains(toType));
    }

    public static SchemaMapping defaults() {
        Set<Class<?>>[] types = new Set[2100];
        types[Types.ARRAY] = setOf(Object[].class);
        types[Types.BIGINT] = setOf(BigInteger.class, Long.class);
        return new SchemaMapping(types);
    }

    private static Set<Class<?>> setOf(Class<?>... cls) {
        return ImmutableSet.copyOf(cls);
    }
}
