package com.pragma.microserviciocasas.category.domain.usecases;

import com.pragma.microserviciocasas.category.domain.exceptions.DepartmentAlreadyExistsException;
import com.pragma.microserviciocasas.category.domain.models.DepartmentModel;
import com.pragma.microserviciocasas.category.domain.ports.in.DepartmentServicePort;
import com.pragma.microserviciocasas.category.domain.ports.out.DepartmentPersistencePort;
import com.pragma.microserviciocasas.category.domain.utils.PageResult;

public class DepartmentUseCase implements DepartmentServicePort {
    private final DepartmentPersistencePort departmentPersistencePort;

    public DepartmentUseCase(DepartmentPersistencePort departmentPersistencePort) {
        this.departmentPersistencePort = departmentPersistencePort;
    }

    @Override
    public void save(DepartmentModel departmentModel) {
        DepartmentModel department = departmentPersistencePort.getDepartmentByName(departmentModel.getName());

        if (department != null) {
            throw new DepartmentAlreadyExistsException();
        }
        departmentPersistencePort.save(departmentModel);
    }

    @Override
    public PageResult<DepartmentModel> getDepartments(Integer page, Integer size, boolean orderAsc) {
        return departmentPersistencePort.getDepartments(page, size, orderAsc);
    }
}
