package com.pragma.microserviciocasas.domain.utils.validations;

import com.pragma.microserviciocasas.domain.exceptions.IdCannotBeNullException;
import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.domain.exceptions.InvalidNumberException;
import com.pragma.microserviciocasas.domain.exceptions.InvalidPublicationDateActiveException;
import com.pragma.microserviciocasas.domain.models.CategoryModel;
import com.pragma.microserviciocasas.domain.models.LocationModel;
import com.pragma.microserviciocasas.domain.utils.enumerations.PublicationStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.HOME_FIELD_NUMBER_MIN;
import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.HOME_PUBLISHED_ACTIVE_MAX_DAYS;

public class DomainValidations {

    public static void isNullOrBlankValidationC(Long id, String name, String description, Integer rooms, Integer bathrooms,
                                                BigDecimal price, LocalDate publicationDate, LocalDate publicationDateActive, PublicationStatus status,
                                                CategoryModel category, LocationModel location) {
        if (id == null || id.toString().isBlank()) {
            throw new IdCannotBeNullException();
        }
        if (name == null || name.isBlank()) {
            throw new EmptyFieldException();
        }
        if (description == null || description.isBlank()) {
            throw new EmptyFieldException();
        }
        if (rooms == null || rooms.toString().isBlank()) {
            throw new EmptyFieldException();
        }
        if (bathrooms == null || bathrooms.toString().isBlank()) {
            throw new EmptyFieldException();
        }
        if (price == null || price.toString().isBlank()) {
            throw new EmptyFieldException();
        }
        if (publicationDate == null || publicationDate.toString().isBlank()) {
            throw new EmptyFieldException();
        }
        if (publicationDateActive == null || publicationDateActive.toString().isBlank()) {
            throw new EmptyFieldException();
        }
        if (status == null || status.toString().isBlank()) {
            throw new EmptyFieldException();
        }
        if (category == null || category.getId() == null || category.getId().toString().isBlank()) {
            throw new IdCannotBeNullException();
        }
        if (location == null || location.getId() == null || location.getId().toString().isBlank()) {
            throw new IdCannotBeNullException();
        }
    }

    //Validation for metods setters
    public static void isNullOrBlankValidationS(Object field) {
        if (field == null || field.toString().isBlank()) {
            throw new EmptyFieldException();
        }
    }

    public static void isNullOrBlankValidationI(Object object) {
        if (object == null || object.toString().isBlank()) {
            throw new IdCannotBeNullException();
        }
    }

    // Validation for Numbers
    public static void isValidNumberValidation(String number) {
        boolean isValid = number.matches("\\d+");
        if (!isValid) {
            throw new InvalidNumberException();
        }
        if (Double.parseDouble(number) <= HOME_FIELD_NUMBER_MIN) {
            throw new InvalidNumberException();
        }
    }

    // Validation for publication date active
    public static void isValidPublicationDateActiveValidation(LocalDate publicationDateActive, LocalDate publicationDate) {
        if (publicationDateActive.isBefore(publicationDate)) {
            throw new InvalidPublicationDateActiveException();
        }
        if (publicationDateActive.isAfter(publicationDate.plusDays(HOME_PUBLISHED_ACTIVE_MAX_DAYS))) {
            throw new InvalidPublicationDateActiveException();
        }
    }
}
