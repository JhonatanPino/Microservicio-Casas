package com.pragma.microserviciocasas.category.infrastructure.repositories.mysql;

import com.pragma.microserviciocasas.category.infrastructure.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);

    Page<CategoryEntity> findAll(Pageable pageable);
}
