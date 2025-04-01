package com.pragma.microserviciocasas.category.application.services;

import com.pragma.microserviciocasas.category.application.dto.request.SaveDepartmentRequest;
import com.pragma.microserviciocasas.category.application.dto.response.DepartmentResponse;
import com.pragma.microserviciocasas.category.application.dto.response.SaveDepartmentResponse;
import com.pragma.microserviciocasas.category.domain.utils.PageResult;

public interface DepartmentService {
    SaveDepartmentResponse save(SaveDepartmentRequest request);

    PageResult<DepartmentResponse> getDepartments(Integer page, Integer size, boolean orderAsc);
}
