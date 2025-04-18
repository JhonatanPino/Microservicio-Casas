package com.pragma.microserviciocasas.infrastructure.mappers;

import com.pragma.microserviciocasas.domain.models.DepartmentModel;
import com.pragma.microserviciocasas.infrastructure.entities.DepartmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentEntityMapper {

    DepartmentEntity modelToEntity(DepartmentModel departmentModel);

    DepartmentModel entityToModel(DepartmentEntity departmentEntity);

}
