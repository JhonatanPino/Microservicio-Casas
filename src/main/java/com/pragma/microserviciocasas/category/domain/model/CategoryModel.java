package com.pragma.microserviciocasas.category.domain.model;

import com.pragma.microserviciocasas.category.domain.exceptions.DescriptionMaxSizeExceededException;
import com.pragma.microserviciocasas.category.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.category.domain.exceptions.NameMaxSizeExceededException;
import com.pragma.microserviciocasas.category.domain.utils.constants.DomainConstants;

import java.util.Objects;

public class CategoryModel {
    private Long id;
    private String name;
    private String description;

    public CategoryModel(Long id, String name, String description) {
        if (name.length() > 50){
            throw new NameMaxSizeExceededException();
        }
        if (name.isEmpty()){
            throw new EmptyFieldException();
        }

        if (description.length() > 90){
            throw new DescriptionMaxSizeExceededException();
        }
        if (description.isEmpty()){
            throw new EmptyFieldException();
        }

        this.id = id;
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = Objects.requireNonNull(description,  DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
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
        if (name.length() > 50){
            throw new NameMaxSizeExceededException();
        }
        if (name.isEmpty()){
            throw new EmptyFieldException();
        }
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }

    public void setDescription(String description) {
        if (description.length() > 90){
            throw new DescriptionMaxSizeExceededException();
        }
        if (description.isEmpty()){
            throw new EmptyFieldException();
        }
        this.description = Objects.requireNonNull(description,  DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

}

