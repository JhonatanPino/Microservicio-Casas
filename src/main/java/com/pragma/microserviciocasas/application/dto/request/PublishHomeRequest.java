package com.pragma.microserviciocasas.application.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.pragma.microserviciocasas.domain.utils.validations.DomainValidations.*;

public record PublishHomeRequest(String name, String description, Integer rooms, Integer bathrooms,
                                 BigDecimal price, LocalDate publicationDate, LocalDate publicationDateActive,
                                 Long idCategory, Long idLocation){
    public PublishHomeRequest {
        isNullOrBlankValidationS(name);
        isNullOrBlankValidationS(description);
        isNullOrBlankValidationS(publicationDate);
        isNullOrBlankValidationS(publicationDateActive);
        isNullOrBlankValidationS(idCategory);
        isNullOrBlankValidationS(idLocation);

        isValidNumberValidation(rooms.toString());
        isValidNumberValidation(bathrooms.toString());
        isValidNumberValidation(price.toString());

        isValidPublicationDateActiveValidation(publicationDateActive, publicationDate);
    }
}
