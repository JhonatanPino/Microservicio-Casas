package com.pragma.microserviciocasas.infrastructure.repositories.mysql;

import com.pragma.microserviciocasas.infrastructure.entities.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

     Optional<LocationEntity> findById(Long id);

     //Page<LocationEntity> findAll(Pageable pageable);
}
