package com.yammer.dropwizard.db.validation;

/**
 * An Exception thrown when the database schema doesn't meet a requirement.
 */
public class SchemaValidationException extends Exception {

    /**
     * Creates a new {@link SchemaValidationException} for the given DAO class with the given errors.
     * @param cls the {@link Class} for the DAO whose requirements weren't met
     * @param errors the errors in the schema
     */
    public SchemaValidationException(Class<?> cls, Iterable<String> errors) {
        super(formatMessage(cls, errors));
    }

    private static String formatMessage(Class<?> cls, Iterable<String> errors) {
        final StringBuilder msg = new StringBuilder(cls.getCanonicalName())
                .append(" has the following errors:\n");
        for (String error : errors) {
            msg.append("  * ").append(error).append("\n");
        }
        return msg.toString();
    }
}
