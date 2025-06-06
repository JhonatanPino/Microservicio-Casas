package com.pragma.microserviciocasas.domain.utils;

import com.pragma.microserviciocasas.domain.exceptions.*;
import com.pragma.microserviciocasas.domain.models.CategoryModel;
import com.pragma.microserviciocasas.domain.models.LocationModel;
import com.pragma.microserviciocasas.domain.utils.enumerations.PublicationStatus;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.pragma.microserviciocasas.domain.utils.validations.DomainValidations.*;
import static org.junit.jupiter.api.Assertions.*;

class DomainValidationsTest {

    @Test
    void shouldThrowEmptyFieldExceptionForNullDescription() {
        Exception exception = assertThrows(EmptyFieldException.class, () ->
                isNullOrBlankValidationC(1L, null, "Valid Description", 2, 1,
                        BigDecimal.valueOf(100000), LocalDate.now(), LocalDate.now().plusDays(10),
                        PublicationStatus.PUBLISHED, new CategoryModel(1L, "Category", "Description"),
                        new LocationModel(1L, "Sector", null))
        );
        assertNotNull(exception);
    }

    @Test
    void shouldThrowEmptyFieldExceptionForNullRooms() {
        Exception exception = assertThrows(EmptyFieldException.class, () ->
                isNullOrBlankValidationC(1L, "Name", "Description", null, 1,
                        BigDecimal.valueOf(100000), LocalDate.now(), LocalDate.now().plusDays(10),
                        PublicationStatus.PUBLISHED, new CategoryModel(1L, "Category", "Description"),
                        new LocationModel(1L, "Sector", null))
        );
        assertNotNull(exception);
    }

    @Test
    void shouldThrowInvalidNumberExceptionForInvalidRooms() {
        Exception exception = assertThrows(InvalidNumberException.class, () ->
                isValidNumberValidation("-1")
        );
        assertNotNull(exception);
    }

    @Test
    void shouldThrowInvalidPublicationDateActiveExceptionForInvalidDates() {
        Exception exception = assertThrows(InvalidPublicationDateActiveException.class, () ->
                isValidPublicationDateActiveValidation(LocalDate.now().minusDays(1), LocalDate.now())
        );
        assertNotNull(exception);
    }

    @Test
    void shouldThrowEmptyFieldExceptionForNullBathrooms() {
        assertThrows(EmptyFieldException.class, () ->
                isNullOrBlankValidationC(1L, "Name", "Description", 2, null,
                        BigDecimal.valueOf(100000), LocalDate.now(), LocalDate.now().plusDays(10),
                        PublicationStatus.PUBLISHED, new CategoryModel(1L, "Category", "Description"),
                        new LocationModel(1L, "Sector", null))
        );
    }

    @Test
    void shouldThrowEmptyFieldExceptionForNullPrice() {
        assertThrows(EmptyFieldException.class, () ->
                isNullOrBlankValidationC(1L, "Name", "Description", 2, 1,
                        null, LocalDate.now(), LocalDate.now().plusDays(10),
                        PublicationStatus.PUBLISHED, new CategoryModel(1L, "Category", "Description"),
                        new LocationModel(1L, "Sector", null))
        );
    }

    @Test
    void shouldThrowEmptyFieldExceptionForNullPublicationDate() {
        assertThrows(EmptyFieldException.class, () ->
                isNullOrBlankValidationC(1L, "Name", "Description", 2, 1,
                        BigDecimal.valueOf(100000), null, LocalDate.now().plusDays(10),
                        PublicationStatus.PUBLISHED, new CategoryModel(1L, "Category", "Description"),
                        new LocationModel(1L, "Sector", null))
        );
    }

    @Test
    void shouldThrowEmptyFieldExceptionForNullPublicationDateActive() {
        assertThrows(EmptyFieldException.class, () ->
                isNullOrBlankValidationC(1L, "Name", "Description", 2, 1,
                        BigDecimal.valueOf(100000), LocalDate.now(), null,
                        PublicationStatus.PUBLISHED, new CategoryModel(1L, "Category", "Description"),
                        new LocationModel(1L, "Sector", null))
        );
    }

    @Test
    void shouldThrowEmptyFieldExceptionForNullStatus() {
        assertThrows(EmptyFieldException.class, () ->
                isNullOrBlankValidationC(1L, "Name", "Description", 2, 1,
                        BigDecimal.valueOf(100000), LocalDate.now(), LocalDate.now().plusDays(10),
                        null, new CategoryModel(1L, "Category", "Description"),
                        new LocationModel(1L, "Sector", null))
        );
    }

    @Test
    void shouldThrowIdCannotBeNullExceptionForNullLocation() {
        assertThrows(IdCannotBeNullException.class, () ->
                isNullOrBlankValidationC(1L, "Name", "Description", 2, 1,
                        BigDecimal.valueOf(100000), LocalDate.now(), LocalDate.now().plusDays(10),
                        PublicationStatus.PUBLISHED, new CategoryModel(1L, "Category", "Description"),
                        null)
        );
    }
}
