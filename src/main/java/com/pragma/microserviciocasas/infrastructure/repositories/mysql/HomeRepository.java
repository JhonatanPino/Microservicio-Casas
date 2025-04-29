package com.pragma.microserviciocasas.infrastructure.repositories.mysql;

import com.pragma.microserviciocasas.infrastructure.entities.HomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

public interface HomeRepository extends JpaRepository<HomeEntity, Long> {

    boolean existsByNameAndLocationId(String name, Long idLocation);

    @Modifying
    @Query("UPDATE HomeEntity h SET h.status = 'PUBLISHED' WHERE h.publicationDateActive <= :currentDate")
    void updateStatusToPublishedIfActiveDateReached(@Param("currentDate") LocalDate currentDate);


}
