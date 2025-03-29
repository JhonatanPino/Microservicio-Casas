package com.pragma.microserviciocasas.category.infrastructure.exceptionshandler;

public final class ExceptionConstants {
    private ExceptionConstants(){}

    public static final String NAME_MAX_SIZE_MESSAGE = "The name of the category can not exceed 50 characters";
    public static final String DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the category can not exceed 90 characters";
    public static final String CATEGORY_EXISTS_EXCEPTION = "The category already exists";
    public static final String FIELD_CANNOT_EMPTY_MESSAGE = "Field cannot be empty";
}
