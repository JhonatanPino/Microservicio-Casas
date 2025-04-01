package com.pragma.microserviciocasas.category.infrastructure.repositories.mysql;

import com.pragma.microserviciocasas.category.infrastructure.entities.DepartmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository  extends JpaRepository<DepartmentEntity, Long> {
    Optional<DepartmentEntity> findByName(String name);

    Page<DepartmentEntity> findAll(Pageable pageable);

}
