package com.pragma.microserviciocasas.application.mappers;

import com.pragma.microserviciocasas.application.dto.request.PublishHomeRequest;
import com.pragma.microserviciocasas.application.dto.response.HomeResponse;;
import com.pragma.microserviciocasas.domain.models.HomeModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface HomeDtoMapper {

    @Mapping(target = "location.id", source = "idLocation")
    @Mapping(target = "category.id", source = "idCategory")
    HomeModel requestToModel(PublishHomeRequest request);


    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "location.sector", target = "locationSector")
    HomeResponse modelToResponse(HomeModel homeModel);

}
