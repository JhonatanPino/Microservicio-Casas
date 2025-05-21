package com.pragma.microserviciocasas.infrastructure.mappers;

import com.pragma.microserviciocasas.domain.models.HomeModel;
import com.pragma.microserviciocasas.infrastructure.entities.HomeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {LocationEntityMapper.class, CategoryEntityMapper.class})
public interface HomeEntityMapper {

    HomeEntity modelToEntity(HomeModel homeModel);

    HomeModel entityToModel(HomeEntity homeEntity);

    List<HomeModel> entityListToModelList(List<HomeEntity> content);

}
