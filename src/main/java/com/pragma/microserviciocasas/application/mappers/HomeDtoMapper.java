package com.pragma.microserviciocasas.application.mappers;

import com.pragma.microserviciocasas.application.dto.request.PublishHomeRequest;
import com.pragma.microserviciocasas.application.dto.response.HomeResponse;;
import com.pragma.microserviciocasas.domain.models.HomeModel;
import com.pragma.microserviciocasas.domain.utils.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface HomeDtoMapper {

    @Mapping(target = "location.id", source = "idLocation")
    @Mapping(target = "category.id", source = "idCategory")
    HomeModel requestToModel(PublishHomeRequest publishHomeRequest);


    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "location.sector", target = "locationSector")
    @Mapping(source = "location.city.name", target = "cityName")
    @Mapping(source = "location.city.department.name", target = "departmentName")
    HomeResponse modelToResponse(HomeModel homeModel);

    PageResult<HomeResponse> modelListToResponseList(PageResult<HomeModel> homeModelPageResult);

}
