package com.pragma.microserviciocasas.infrastructure.exceptionshandler;

public final class ExceptionConstants {
    private ExceptionConstants(){}

    // Category
    public static final String CATEGORY_EXISTS_EXCEPTION = "The category already exists";
    public static final String CATEGORY_NAME_MAX_SIZE_MESSAGE = "The name of the category can not exceed 50 characters";
    public static final String CATEGORY_DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the category can not exceed 90 characters";

    // Department
    public static final String DEPARTMENT_EXISTS_EXCEPTION = "The department already exists";
    public static final String DEPARTMENT_NAME_MAX_SIZE_MESSAGE = "The name of the department can not exceed 50 characters";
    public static final String DEPARTMENT_DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the department can not exceed 120 characters";

    // City
    public static final String CITY_EXISTS_EXCEPTION = "The city already exists";
    public static final String CITY_NAME_MAX_SIZE_MESSAGE = "The name of the city can not exceed 50 characters";
    public static final String CITY_DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the city can not exceed 120 characters";

    // General
    public static final String FIELD_CANNOT_EMPTY_MESSAGE = "Field cannot be empty";
}
