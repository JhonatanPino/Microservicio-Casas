package com.pragma.microserviciocasas.infrastructure.repositories.mysql;

import com.pragma.microserviciocasas.infrastructure.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    // Custom query methods can be defined here if needed
    // For example, you can add methods to find departments by name or other criteria
    // Optional<DepartmentEntity> findByName(String name);
}
