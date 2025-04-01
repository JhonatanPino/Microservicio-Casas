package com.pragma.microserviciocasas.category.application.services.impl;

import com.pragma.microserviciocasas.category.application.dto.request.SaveDepartmentRequest;
import com.pragma.microserviciocasas.category.application.dto.response.DepartmentResponse;
import com.pragma.microserviciocasas.category.application.dto.response.SaveDepartmentResponse;
import com.pragma.microserviciocasas.category.application.mappers.DepartmentDtoMapper;
import com.pragma.microserviciocasas.category.application.services.DepartmentService;
import com.pragma.microserviciocasas.category.domain.ports.in.DepartmentServicePort;
import com.pragma.microserviciocasas.category.domain.utils.PageResult;
import com.pragma.microserviciocasas.commons.configurations.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentServicePort departmentServicePort;
    private final DepartmentDtoMapper departmentDtoMapper;

    @Override
    public SaveDepartmentResponse save(SaveDepartmentRequest request) {
        departmentServicePort.save(departmentDtoMapper.requestToModel(request));
        return new SaveDepartmentResponse(Constants.SAVE_DEPARTMENT_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public PageResult<DepartmentResponse> getDepartments(Integer page, Integer size, boolean orderAsc) {
        return departmentDtoMapper.modelListToResponseList(departmentServicePort.getDepartments(page, size, orderAsc));
    }
}
