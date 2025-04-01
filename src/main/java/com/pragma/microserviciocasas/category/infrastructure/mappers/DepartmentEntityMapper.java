package com.pragma.microserviciocasas.category.infrastructure.mappers;

import com.pragma.microserviciocasas.category.domain.models.DepartmentModel;
import com.pragma.microserviciocasas.category.infrastructure.entities.DepartmentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentEntityMapper {
    DepartmentEntity modelToEntity(DepartmentModel departmentModel);

    DepartmentModel entityToModel(DepartmentEntity departmentEntity);

    List<DepartmentModel> entityListToModelList(List<DepartmentEntity> departments);
}
