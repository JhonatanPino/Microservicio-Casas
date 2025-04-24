package com.pragma.microserviciocasas.infrastructure.entities;

import com.pragma.microserviciocasas.domain.utils.enumerations.PublicationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer rooms;
    private Integer bathrooms;
    private BigDecimal price;
    private LocalDate publicationDate;
    private LocalDate publicationDateActive;
    @Enumerated(EnumType.STRING)
    private PublicationStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", nullable = false)
    private LocationEntity location;

}
