package com.pragma.microserviciocasas.application.dto.response;
import com.pragma.microserviciocasas.domain.utils.enumerations.PublicationStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record HomeResponse(Long id, String name, String description, Integer rooms, Integer bathrooms,
                          BigDecimal price, LocalDate publicationDate, LocalDate publicationDateActive,
                          PublicationStatus status, String categoryName, String locationSector, String cityName, String departmentName) {
}
