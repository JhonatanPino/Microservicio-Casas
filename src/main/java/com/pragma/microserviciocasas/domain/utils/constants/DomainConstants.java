package com.pragma.microserviciocasas.domain.utils.constants;

public class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    // Validation messages
    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' can not be null";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' can not be null";
    public static final Integer FIELD_NAME_MAX_SIZE = 50;
    public static final Integer CATEGORY_FIELD_DESCRIPTION_MAX_SIZE = 90;
    public static final Integer FIELD_DESCRIPTION_MAX_SIZE = 120;
}
