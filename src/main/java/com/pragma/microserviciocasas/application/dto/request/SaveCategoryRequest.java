package com.pragma.microserviciocasas.application.dto.request;

import com.pragma.microserviciocasas.domain.exceptions.CategoryDescriptionMaxSizeExceededException;
import com.pragma.microserviciocasas.domain.exceptions.CategoryNameMaxSizeExceededException;
import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;

import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.CATEGORY_FIELD_DESCRIPTION_MAX_SIZE;
import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.CATEGORY_FIELD_NAME_MAX_SIZE;

public record SaveCategoryRequest(String name, String description) {
    public SaveCategoryRequest {
        if (name.length() > CATEGORY_FIELD_NAME_MAX_SIZE){
            throw new CategoryNameMaxSizeExceededException();
        }
        if (name.isBlank()) {
            throw new EmptyFieldException();
        }

        if (description.length() > CATEGORY_FIELD_DESCRIPTION_MAX_SIZE){
            throw new CategoryDescriptionMaxSizeExceededException();
        }
        if (description.isBlank()) {
            throw new EmptyFieldException();
        }
    }
}
