package com.pragma.microserviciocasas.infrastructure.repositories.mysql;

import com.pragma.microserviciocasas.infrastructure.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {

}
