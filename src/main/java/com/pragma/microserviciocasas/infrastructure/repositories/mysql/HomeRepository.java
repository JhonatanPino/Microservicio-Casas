package com.pragma.microserviciocasas.infrastructure.repositories.mysql;

import com.pragma.microserviciocasas.infrastructure.entities.HomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<HomeEntity, Long> {

    boolean existsByNameAndLocationId(String name, Long idLocation);


}
