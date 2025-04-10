package com.pragma.microserviciocasas.infrastructure.mappers;

import com.pragma.microserviciocasas.domain.models.LocationModel;
import com.pragma.microserviciocasas.infrastructure.entities.LocationEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationEntityMapper {

     LocationEntity modelToEntity(LocationModel locationModel);

     LocationModel entityToModel(LocationEntity locationEntity);

     //List<LocationModel> entityListToModelList(List<LocationEntity> locations);
}
