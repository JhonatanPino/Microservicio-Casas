package com.pragma.microserviciocasas.infrastructure.repositories.mysql;

import com.pragma.microserviciocasas.infrastructure.entities.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

    boolean existsBySectorAndCity_Id(String sector, Long idCity);

    //Page<LocationEntity> findAll(Pageable pageable);
}
