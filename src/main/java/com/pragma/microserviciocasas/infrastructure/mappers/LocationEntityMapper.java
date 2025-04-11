package com.pragma.microserviciocasas.infrastructure.mappers;

import com.pragma.microserviciocasas.domain.models.LocationModel;
import com.pragma.microserviciocasas.infrastructure.entities.LocationEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DepartmentEntityMapper.class})
public interface LocationEntityMapper {

     LocationEntity modelToEntity(LocationModel locationModel);

     LocationModel entityToModel(LocationEntity locationEntity);

     //List<LocationModel> entityListToModelList(List<LocationEntity> locations);
}



/*
uses: Se utiliza para indicar que LocationEntityMapper debe usar DepartmentEntityMapper para mapear las propiedades
 relacionadas con DepartmentModel y DepartmentEntity.
Mapeo explícito: Ahora MapStruct sabrá cómo manejar la conversión de DepartmentModel a DepartmentEntity y viceversa.
 */