package com.pragma.microserviciocasas.infrastructure.repositories.mysql;

import com.pragma.microserviciocasas.infrastructure.entities.HomeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface HomeRepository extends JpaRepository<HomeEntity, Long> {

    boolean existsByNameAndLocationId(String name, Long idLocation);

    @Modifying
    @Query("UPDATE HomeEntity h SET h.status = 'PUBLISHED' WHERE h.publicationDateActive <= :currentDate")
    void updateStatusToPublishedIfActiveDateReached(@Param("currentDate") LocalDate currentDate);

    @Query("SELECT l FROM HomeEntity l " +
            "WHERE LOWER(l.location.sector) LIKE LOWER(CONCAT('%', :text, '%')) " +
            "OR LOWER(l.category.name) LIKE LOWER(CONCAT('%', :text, '%'))" +
            "OR l.rooms = :text " +
            "OR l.bathrooms = :text " +
            "OR l.price = :text")
    Page<HomeEntity> findBySectorOrCategoryOrRoomsOrBathroomsOrPrice(@Param("text") String text, Pageable pagination);

}
