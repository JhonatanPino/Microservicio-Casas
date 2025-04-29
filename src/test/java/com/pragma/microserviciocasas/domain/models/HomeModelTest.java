package com.pragma.microserviciocasas.domain.models;

import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.domain.exceptions.IdCannotBeNullException;
import com.pragma.microserviciocasas.domain.exceptions.InvalidNumberException;
import com.pragma.microserviciocasas.domain.exceptions.InvalidPublicationDateActiveException;
import com.pragma.microserviciocasas.domain.utils.enumerations.PublicationStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HomeModelTest {

    @Mock
    private CategoryModel category;
    private LocationModel location;


    @BeforeEach
    void setUp() {
        category = new CategoryModel(1L, "CategoryName", "CategoryDescription");
        location = new LocationModel(1L, "LocationSector", new CityModel());
    }

    @Test
    void shouldCreateHomeModelSuccessfully() {
        HomeModel home = new HomeModel(
                1L, "Home Name", "Description", 3, 2,
                BigDecimal.valueOf(100000), LocalDate.now(),
                LocalDate.now().plusDays(10), PublicationStatus.PUBLISHED,
                category, location
        );

        assertNotNull(home);
        assertEquals("Home Name", home.getName());
        assertEquals(3, home.getRooms());
    }

    @Test
    void shouldThrowExceptionWhenIdIsNull() {
        assertThrows(IdCannotBeNullException.class, () -> new HomeModel(
                null, "Home Name", "Description", 3, 2,
                BigDecimal.valueOf(100000), LocalDate.now(),
                LocalDate.now().plusDays(10), PublicationStatus.PUBLISHED,
                category, location
        ));
    }

    @Test
    void shouldThrowExceptionWhenNameIsEmpty() {
        assertThrows(EmptyFieldException.class, () -> new HomeModel(
                1L, "", "Description", 3, 2,
                BigDecimal.valueOf(100000), LocalDate.now(),
                LocalDate.now().plusDays(10), PublicationStatus.PUBLISHED,
                category, location
        ));
    }

    @Test
    void shouldThrowExceptionWhenRoomsIsInvalid() {
        assertThrows(InvalidNumberException.class, () -> new HomeModel(
                1L, "Home Name", "Description", -1, 2,
                BigDecimal.valueOf(100000), LocalDate.now(),
                LocalDate.now().plusDays(10), PublicationStatus.PUBLISHED,
                category, location
        ));
    }

    @Test
    void shouldThrowExceptionWhenPublicationDateActiveIsInvalid() {
        assertThrows(InvalidPublicationDateActiveException.class, () -> new HomeModel(
                1L, "Home Name", "Description", 3, 2,
                BigDecimal.valueOf(100000), LocalDate.now(),
                LocalDate.now().minusDays(1), PublicationStatus.PUBLISHED,
                category, location
        ));
    }
}