package com.pragma.microserviciocasas.infrastructure.exceptionshandler;

public final class ExceptionConstants {

    private ExceptionConstants(){}

    // Category
    public static final String CATEGORY_EXISTS_EXCEPTION = "The category already exists";
    public static final String CATEGORY_NAME_MAX_SIZE_MESSAGE = "The name of the category can not exceed 50 characters";
    public static final String CATEGORY_DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the category can not exceed 90 characters";
    public static final String INVALID_PAGE_OR_SIZE = "Page and size must be greater than or equal to 0";

    // General

}
