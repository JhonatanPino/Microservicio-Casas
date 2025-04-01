package com.pragma.microserviciocasas.category.infrastructure.mappers;

import com.pragma.microserviciocasas.category.domain.models.CategoryModel;
import com.pragma.microserviciocasas.category.infrastructure.entities.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {
    CategoryEntity modelToEntity(CategoryModel categoryModel);

    CategoryModel entityToModel(CategoryEntity categoryEntity);

    List<CategoryModel> entityListToModelList(List<CategoryEntity> categories);
}
