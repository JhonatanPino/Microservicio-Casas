package com.pragma.microserviciocasas.category.application.mappers;

import com.pragma.microserviciocasas.category.application.dto.request.SaveDepartmentRequest;
import com.pragma.microserviciocasas.category.application.dto.response.DepartmentResponse;
import com.pragma.microserviciocasas.category.domain.models.DepartmentModel;
import com.pragma.microserviciocasas.category.domain.utils.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentDtoMapper {
    DepartmentModel requestToModel(SaveDepartmentRequest saveDepartmentRequest);

    DepartmentResponse modelToResponse(DepartmentModel departmentModel);

    PageResult<DepartmentResponse> modelListToResponseList(PageResult<DepartmentModel> departments);
}
