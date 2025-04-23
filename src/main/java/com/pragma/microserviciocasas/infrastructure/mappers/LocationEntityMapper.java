package com.pragma.microserviciocasas.infrastructure.mappers;

import com.pragma.microserviciocasas.domain.models.CityModel;
import com.pragma.microserviciocasas.domain.models.LocationModel;
import com.pragma.microserviciocasas.infrastructure.entities.CityEntity;
import com.pragma.microserviciocasas.infrastructure.entities.LocationEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DepartmentEntityMapper.class})
public interface LocationEntityMapper {

     LocationEntity modelToEntity(LocationModel locationModel);

     LocationModel entityToModel(LocationEntity locationEntity);

    CityModel entityToModel(CityEntity cityEntity);

    List<LocationModel> entityListToModelList(List<LocationEntity> content);

}
