package com.pragma.microserviciocasas.infrastructure.repositories.mysql;

import com.pragma.microserviciocasas.infrastructure.entities.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
    // Custom query methods can be defined here if needed
    // For example, you can add methods to find locations by sector or cityId
    // Optional<LocationEntity> findBySector(String sector);
    // List<LocationEntity> findByCityId(Long cityId);
}
