package com.pragma.microserviciocasas.infrastructure.repositories.mysql;

import com.pragma.microserviciocasas.infrastructure.entities.LocationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

    boolean existsBySectorAndCity_Id(String sector, Long idCity);

    @Query("SELECT l FROM LocationEntity l " +
            "WHERE LOWER(l.city.name) LIKE LOWER(CONCAT('%', :text, '%')) " +
            "OR LOWER(l.city.department.name) LIKE LOWER(CONCAT('%', :text, '%'))")
    Page<LocationEntity> findByCityOrDepartmentName(@Param("text") String text, Pageable pageable);


}

/*
Consulta ajustada: Si las relaciones están configuradas correctamente, la consulta es válida. Sin embargo, si necesitas cargar
 las relaciones de manera ansiosa para evitar problemas de inicialización perezosa, puedes usar JOIN FETCH:
@Query("SELECT l FROM LocationEntity l " +
            "JOIN FETCH l.city c " +
            "JOIN FETCH c.department d " +
            "WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :text, '%')) " +
            "OR LOWER(d.name) LIKE LOWER(CONCAT('%', :text, '%'))")
    Page<LocationEntity> findByCityOrDepartmentName(@Param("text") String text, Pageable pageable);*/