package com.pragma.microserviciocasas.application.mappers;

import com.pragma.microserviciocasas.application.dto.request.SaveLocationRequest;
import com.pragma.microserviciocasas.application.dto.response.LocationResponse;
import com.pragma.microserviciocasas.domain.models.LocationModel;
import com.pragma.microserviciocasas.infrastructure.entities.LocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)

public interface LocationDtoMapper {

    @Mapping(target = "city.id", source = "idCity")
    LocationModel requestToModel(SaveLocationRequest saveLocationRequest);

    /*@Mapping(target = "city.id", source = "idCity")
    LocationEntity requestToEntity(SaveLocationRequest request);

    @Mapping(target = "cityName", source = "city.name")
    @Mapping(target = "departmentName", source = "city.department.name")
    LocationResponse entityToResponse(LocationEntity entity);

    LocationResponse modelToResponse(LocationModel locationModel);*/
}
