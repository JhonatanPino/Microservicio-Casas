package com.pragma.microserviciocasas.domain.utils.constants;

public class DomainConstants {

    //  Categories Validation messages
    public static final String CATEGORY_FIELD_NAME_NULL_MESSAGE = "Field 'name' of category can not be null";
    public static final String CATEGORY_FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' of category can not be null";
    public static final Integer CATEGORY_FIELD_NAME_MAX_SIZE = 50;
    public static final Integer CATEGORY_FIELD_DESCRIPTION_MAX_SIZE = 90;

    //  Department Validation messages
    public static final String DEPARTMENT_FIELD_NAME_NULL_MESSAGE = "Field 'name' of department can not be null";
    public static final String DEPARTMENT_FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' of department can not be null";
    public static final Integer DEPARTMENT_FIELD_NAME_MAX_SIZE = 50;
    public static final Integer DEPARTMENT_FIELD_DESCRIPTION_MAX_SIZE = 120;

    //  City Validation messages
    public static final String CITY_FIELD_NAME_NULL_MESSAGE = "Field 'name' of city can not be null";
    public static final String CITY_FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' of city can not be null";
    public static final String CITY_FIELD_DEPARTMENT_NULL_MESSAGE = "Field 'department' of city can not be null";
    public static final Integer CITY_FIELD_NAME_MAX_SIZE = 50;
    public static final Integer CITY_FIELD_DESCRIPTION_MAX_SIZE = 120;

    // Location validation messages
    public static final String LOCATION_FIELD_SECTOR_NULL_MESSAGE = "Field 'sector' of location can not be null";
    public static final String LOCATION_FIELD_CITY_NULL_MESSAGE = "Field 'city' of location can not be null";
    public static final Integer LOCATION_FIELD_SECTOR_MAX_SIZE = 60;
}
