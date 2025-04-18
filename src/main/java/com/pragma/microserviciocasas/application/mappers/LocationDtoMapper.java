package com.pragma.microserviciocasas.application.mappers;

import com.pragma.microserviciocasas.application.dto.request.SaveLocationRequest;
import com.pragma.microserviciocasas.application.dto.response.LocationResponse;
import com.pragma.microserviciocasas.domain.models.LocationModel;
import com.pragma.microserviciocasas.domain.utils.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface LocationDtoMapper {

    @Mapping(target = "city.id", source = "idCity")
    LocationModel requestToModel(SaveLocationRequest saveLocationRequest);

    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "city.department.name", target = "departmentName")
    LocationResponse modelToResponse(LocationModel locationModel);

    PageResult<LocationResponse> modelListToResponseList(PageResult<LocationModel> locationModelPageResult);

}
