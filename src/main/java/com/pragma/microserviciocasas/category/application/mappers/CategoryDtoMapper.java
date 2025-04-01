package com.pragma.microserviciocasas.category.application.mappers;

import com.pragma.microserviciocasas.category.application.dto.request.SaveCategoryRequest;
import com.pragma.microserviciocasas.category.application.dto.response.CategoryResponse;
import com.pragma.microserviciocasas.category.domain.models.CategoryModel;
import com.pragma.microserviciocasas.category.domain.utils.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryDtoMapper {
    CategoryModel requestToModel(SaveCategoryRequest saveCategoryRequest);

    CategoryResponse modelToResponse(CategoryModel categoryModel);

    PageResult<CategoryResponse> modelListToResponseList(PageResult<CategoryModel> categories);

}
