package com.pragma.microserviciocasas.infrastructure.mappers;

import com.pragma.microserviciocasas.domain.models.CityModel;
import com.pragma.microserviciocasas.infrastructure.entities.CityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityEntityMapper {
    CityEntity modelToEntity(CityModel cityModel);

    CityModel entityToModel(CityEntity cityEntity);

}
