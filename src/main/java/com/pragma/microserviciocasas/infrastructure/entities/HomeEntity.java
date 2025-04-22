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
    private PublicationStatus status;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", nullable = false)
    private LocationEntity location;

}
/*
-cada casa tiene los sigueintes campos:id,nombre, descripcion,
 cantidad de cuartos, cantidad de baños, precio,
 Categoria de inmueble, ubicación (sector, ciudad y departamento),
  fecha de publicación activa (los usuarios solo podran ver la casa, cuando se lista despues de la fecha de publicación,
   esta fecha no puede exeder un mes de la fecha actual),
    estado de la publicación (PUBLICADA, PUBLICACION_PAUSADA,TRASACCION_CURSO, TRANSACCION_FINALIZADA),
     fecha de la publicación
 */