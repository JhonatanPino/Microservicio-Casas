package com.pragma.microserviciocasas.infrastructure.mappers;

import com.pragma.microserviciocasas.domain.models.HomeModel;
import com.pragma.microserviciocasas.infrastructure.entities.HomeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {LocationEntityMapper.class, CategoryEntityMapper.class})
public interface HomeEntityMapper {

    HomeEntity modelToEntity(HomeModel homeModel);

    HomeModel entityToModel(HomeEntity homeEntity);
}
