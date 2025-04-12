package com.pragma.microserviciocasas.domain.models;

import com.pragma.microserviciocasas.domain.exceptions.DepartmentDescriptionMaxSizeExceededException;
import com.pragma.microserviciocasas.domain.exceptions.DepartmentNameMaxSizeExceededException;
import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.domain.utils.constants.DomainConstants;
import java.util.Objects;
import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.DEPARTMENT_FIELD_DESCRIPTION_MAX_SIZE;
import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.DEPARTMENT_FIELD_NAME_MAX_SIZE;

public class DepartmentModel {
    private Long id;
    private String name;
    private String description;

    public DepartmentModel(Long id, String name, String description) {
        if (name.length() > DEPARTMENT_FIELD_NAME_MAX_SIZE){
            throw new DepartmentNameMaxSizeExceededException();
        }
        if (name.isBlank()){
            throw new EmptyFieldException();
        }

        if (description.length() > DEPARTMENT_FIELD_DESCRIPTION_MAX_SIZE){
            throw new DepartmentDescriptionMaxSizeExceededException();
        }
        if (description.isBlank()){
            throw new EmptyFieldException();
        }

        this.id = id;
        this.name = Objects.requireNonNull(name, DomainConstants.DEPARTMENT_FIELD_NAME_NULL_MESSAGE);
        this.description = Objects.requireNonNull(description,  DomainConstants.DEPARTMENT_FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    public DepartmentModel() {

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

    public void setName(String name) {
        if (name.length() > DEPARTMENT_FIELD_NAME_MAX_SIZE){
            throw new DepartmentNameMaxSizeExceededException();
        }
        if (name.isBlank()){
            throw new EmptyFieldException();
        }
        this.name = Objects.requireNonNull(name, DomainConstants.DEPARTMENT_FIELD_NAME_NULL_MESSAGE);
    }

    public void setDescription(String description) {
        if (description.length() > DEPARTMENT_FIELD_DESCRIPTION_MAX_SIZE){
            throw new DepartmentDescriptionMaxSizeExceededException();
        }
        if (description.isBlank()){
            throw new EmptyFieldException();
        }
        this.description = Objects.requireNonNull(description,  DomainConstants.DEPARTMENT_FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
