package com.pragma.microserviciocasas.category.domain.ports.in;

import com.pragma.microserviciocasas.category.domain.models.DepartmentModel;
import com.pragma.microserviciocasas.category.domain.utils.PageResult;

public interface DepartmentServicePort {

    void save(DepartmentModel departmentModel);

    PageResult<DepartmentModel> getDepartments(Integer page, Integer size, boolean orderAsc);

}
