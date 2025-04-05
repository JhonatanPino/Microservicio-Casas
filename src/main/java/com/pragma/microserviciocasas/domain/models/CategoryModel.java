package com.pragma.microserviciocasas.domain.models;

import com.pragma.microserviciocasas.domain.exceptions.CategoryDescriptionMaxSizeExceededException;
import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.domain.exceptions.CategoryNameMaxSizeExceededException;
import com.pragma.microserviciocasas.domain.utils.constants.DomainConstants;
import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.CATEGORY_FIELD_DESCRIPTION_MAX_SIZE;
import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.FIELD_NAME_MAX_SIZE;
import java.util.Objects;

public class CategoryModel {
    private Long id;
    private String name;
    private String description;

    public CategoryModel(Long id, String name, String description) {
        if (name.length() > FIELD_NAME_MAX_SIZE){
            throw new CategoryNameMaxSizeExceededException();
        }
        if (name.isEmpty()){
            throw new EmptyFieldException();
        }

        if (description.length() > CATEGORY_FIELD_DESCRIPTION_MAX_SIZE){
            throw new CategoryDescriptionMaxSizeExceededException();
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
        if (name.length() > FIELD_NAME_MAX_SIZE){
            throw new CategoryNameMaxSizeExceededException();
        }
        if (name.isEmpty()){
            throw new EmptyFieldException();
        }
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }

    public void setDescription(String description) {
        if (description.length() > CATEGORY_FIELD_DESCRIPTION_MAX_SIZE){
            throw new CategoryDescriptionMaxSizeExceededException();
        }
        if (description.isEmpty()){
            throw new EmptyFieldException();
        }
        this.description = Objects.requireNonNull(description,  DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

}

