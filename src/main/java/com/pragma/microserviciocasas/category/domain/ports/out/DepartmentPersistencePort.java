package com.pragma.microserviciocasas.category.domain.ports.out;

import com.pragma.microserviciocasas.category.domain.models.DepartmentModel;
import com.pragma.microserviciocasas.category.domain.utils.PageResult;

public interface DepartmentPersistencePort {

    void save(DepartmentModel departmentModel);

    DepartmentModel getDepartmentByName(String departmentName);

    PageResult<DepartmentModel> getDepartments(Integer page, Integer size, boolean orderAsc);
}
