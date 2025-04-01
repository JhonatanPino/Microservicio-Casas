package com.pragma.microserviciocasas.category.infrastructure.adapters.persistence;

import com.pragma.microserviciocasas.category.domain.models.DepartmentModel;
import com.pragma.microserviciocasas.category.domain.ports.out.DepartmentPersistencePort;
import com.pragma.microserviciocasas.category.domain.utils.PageResult;
import com.pragma.microserviciocasas.category.infrastructure.entities.DepartmentEntity;
import com.pragma.microserviciocasas.category.infrastructure.mappers.DepartmentEntityMapper;
import com.pragma.microserviciocasas.category.infrastructure.repositories.mysql.DepartmentRepository;
import com.pragma.microserviciocasas.commons.configurations.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentPersistenceAdapter implements DepartmentPersistencePort {
    private final DepartmentRepository departmentRepository;
    private final DepartmentEntityMapper departmentEntityMapper;

    @Override
    public void save(DepartmentModel departmentModel) {
        departmentRepository.save(departmentEntityMapper.modelToEntity(departmentModel));
    }

    @Override
    public DepartmentModel getDepartmentByName(String departmentName) {
        return departmentEntityMapper.entityToModel(departmentRepository.findByName(departmentName).orElse(null));
    }

    @Override
    public PageResult<DepartmentModel> getDepartments(Integer page, Integer size, boolean orderAsc) {
        Pageable pagination;
        if (orderAsc) pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        else pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        Page<DepartmentEntity> departments = departmentRepository.findAll(pagination);
        List<DepartmentModel> departmentModels = departmentEntityMapper.entityListToModelList(departments.getContent());
        return new PageResult<>( departmentModels,
                                                    departments.getNumber(),
                                                    departments.getSize(),
                                                    orderAsc,
                                                    departments.getTotalElements(),
                                                    departments.getTotalPages());
    }

}
