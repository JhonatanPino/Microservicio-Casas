package com.pragma.microserviciocasas.infrastructure.repositories.mysql;

import com.pragma.microserviciocasas.infrastructure.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
    // Custom query methods can be defined here if needed
    // For example, you can add methods to find cities by name or other criteria
    // Optional<CityEntity> findByName(String name);
}
