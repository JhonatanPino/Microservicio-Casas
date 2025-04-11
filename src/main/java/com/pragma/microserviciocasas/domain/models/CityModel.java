package com.pragma.microserviciocasas.domain.models;

import com.pragma.microserviciocasas.domain.exceptions.CityDescriptionMaxSizeExceededException;
import com.pragma.microserviciocasas.domain.exceptions.CityNameMaxSizeExceededException;
import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.domain.utils.constants.DomainConstants;
import java.util.Objects;
import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.CITY_FIELD_DESCRIPTION_MAX_SIZE;
import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.CITY_FIELD_NAME_MAX_SIZE;

public class CityModel {
    private Long id;
    private String name;
    private String description;
    private DepartmentModel department;

    public CityModel(Long id, String name, String description, DepartmentModel department) {
        if (name.length() > CITY_FIELD_NAME_MAX_SIZE){
            throw new CityNameMaxSizeExceededException();
        }
        if (name.isBlank()){
            throw new EmptyFieldException();
        }

        if (description.length() > CITY_FIELD_DESCRIPTION_MAX_SIZE){
            throw new CityDescriptionMaxSizeExceededException();
        }
        if (description.isBlank()){
            throw new EmptyFieldException();
        }
        this.id = id;
        this.name = Objects.requireNonNull(name, DomainConstants.CITY_FIELD_NAME_NULL_MESSAGE);
        this.description = Objects.requireNonNull(description,  DomainConstants.CITY_FIELD_DESCRIPTION_NULL_MESSAGE);
        this.department = Objects.requireNonNull(department, DomainConstants.CITY_FIELD_DEPARTMENT_NULL_MESSAGE);
    }
    public CityModel() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public DepartmentModel getDepartment() { return department; }

    public void setName(String name) {
        if (name.length() > CITY_FIELD_NAME_MAX_SIZE){
            throw new CityNameMaxSizeExceededException();
        }
        if (name.isBlank()){
            throw new EmptyFieldException();
        }
        this.name = Objects.requireNonNull(name, DomainConstants.CITY_FIELD_NAME_NULL_MESSAGE);
    }

    public void setDescription(String description) {
        if (description.length() > CITY_FIELD_DESCRIPTION_MAX_SIZE){
            throw new CityDescriptionMaxSizeExceededException();
        }
        if (description.isBlank()){
            throw new EmptyFieldException();
        }
        this.description = Objects.requireNonNull(description,  DomainConstants.CITY_FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    public void setDepartment(DepartmentModel department) {
        this.department = Objects.requireNonNull(department, DomainConstants.CITY_FIELD_DEPARTMENT_NULL_MESSAGE);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
