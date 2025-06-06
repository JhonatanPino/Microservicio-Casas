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

    @Test
    void shouldSetCategorySuccessfully() {
        HomeModel home = new HomeModel();
        CategoryModel category = new CategoryModel(1L, "CategoryName", "CategoryDescription");

        home.setCategory(category);

        assertEquals(category, home.getCategory());
    }

    @Test
    void shouldSetLocationSuccessfully() {
        HomeModel home = new HomeModel();
        LocationModel location = new LocationModel(1L, "LocationSector", new CityModel());

        home.setLocation(location);

        assertEquals(location, home.getLocation());
    }

    @Test
    void testDefaultConstructor() {
        HomeModel home = new HomeModel();

        assertNull(home.getId());
        assertNull(home.getName());
        assertNull(home.getDescription());
        assertNull(home.getRooms());
        assertNull(home.getBathrooms());
        assertNull(home.getPrice());
        assertNull(home.getPublicationDate());
        assertNull(home.getPublicationDateActive());
        assertNull(home.getStatus());
        assertNull(home.getCategory());
        assertNull(home.getLocation());
    }

    @Test
    void testSettersAndGetters() {
        HomeModel home = new HomeModel();

        home.setId(1L);
        assertEquals(1L, home.getId());

        home.setName("Home Name");
        assertEquals("Home Name", home.getName());

        home.setDescription("Description");
        assertEquals("Description", home.getDescription());

        home.setRooms(3);
        assertEquals(3, home.getRooms());

        home.setBathrooms(2);
        assertEquals(2, home.getBathrooms());

        home.setPrice(BigDecimal.valueOf(100000));
        assertEquals(BigDecimal.valueOf(100000), home.getPrice());

        LocalDate publicationDate = LocalDate.now();
        home.setPublicationDate(publicationDate);
        assertEquals(publicationDate, home.getPublicationDate());

        LocalDate publicationDateActive = LocalDate.now().plusDays(10);
        home.setPublicationDateActive(publicationDateActive);
        assertEquals(publicationDateActive, home.getPublicationDateActive());

        home.setStatus(PublicationStatus.PUBLISHED);
        assertEquals(PublicationStatus.PUBLISHED, home.getStatus());

        CategoryModel category = new CategoryModel(1L, "CategoryName", "CategoryDescription");
        home.setCategory(category);
        assertEquals(category, home.getCategory());

        LocationModel location = new LocationModel(1L, "Sector", new CityModel());
        home.setLocation(location);
        assertEquals(location, home.getLocation());
    }
}