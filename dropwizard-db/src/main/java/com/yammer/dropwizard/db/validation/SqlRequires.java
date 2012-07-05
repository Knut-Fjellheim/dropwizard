package com.yammer.dropwizard.db.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines a field requirement of the database schema.
 *
 * When present, the database schema will be validated to ensure the required
 * {@code field} exists in the {@code table} and is of a type that can be
 * marshalled in to the expected {@code type}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface SqlRequires
{
    String table();

    String field();

    Class<?> type();
}
