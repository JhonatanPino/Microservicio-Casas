package com.pragma.microserviciocasas.infrastructure.mappers;

import com.pragma.microserviciocasas.domain.models.CityModel;
import com.pragma.microserviciocasas.infrastructure.entities.CityEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityEntityMapper {
    CityEntity modelToEntity(CityModel cityModel);

    CityModel entityToModel(CityEntity cityEntity);

    //List<CityModel> entityListToModelList(List<CityEntity> cities);

}
