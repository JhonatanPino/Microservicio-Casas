package com.pragma.microserviciocasas.domain.models;

import com.pragma.microserviciocasas.domain.exceptions.CityDescriptionMaxSizeExceededException;
import com.pragma.microserviciocasas.domain.exceptions.CityNameMaxSizeExceededException;
import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import org.junit.jupiter.api.Test;

import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.CITY_FIELD_DESCRIPTION_MAX_SIZE;
import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.CITY_FIELD_NAME_MAX_SIZE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CityModelTest {

    @Test
    void constructorShouldCreateCityModelSuccessfully() {
        DepartmentModel department = mock(DepartmentModel.class);
        CityModel city = new CityModel(1L, "CityName", "CityDescription", department);

        assertEquals(1L, city.getId());
        assertEquals("CityName", city.getName());
        assertEquals("CityDescription", city.getDescription());
        assertEquals(department, city.getDepartment());
    }

    @Test
    void constructorShouldThrowExceptionWhenNameExceedsMaxSize() {
        DepartmentModel department = mock(DepartmentModel.class);
        String longName = "A".repeat(CITY_FIELD_NAME_MAX_SIZE + 1);

        assertThrows(CityNameMaxSizeExceededException.class, () ->
                new CityModel(1L, longName, "Description", department)
        );
    }

    @Test
    void constructorShouldThrowExceptionWhenDescriptionExceedsMaxSize() {
        DepartmentModel department = mock(DepartmentModel.class);
        String longDescription = "A".repeat(CITY_FIELD_DESCRIPTION_MAX_SIZE + 1);

        assertThrows(CityDescriptionMaxSizeExceededException.class, () ->
                new CityModel(1L, "Name", longDescription, department)
        );
    }

    @Test
    void constructorShouldThrowExceptionWhenNameIsBlank() {
        DepartmentModel department = mock(DepartmentModel.class);

        assertThrows(EmptyFieldException.class, () ->
                new CityModel(1L, " ", "Description", department)
        );
    }

    @Test
    void constructorShouldThrowExceptionWhenDescriptionIsBlank() {
        DepartmentModel department = mock(DepartmentModel.class);

        assertThrows(EmptyFieldException.class, () ->
                new CityModel(1L, "Name", " ", department)
        );
    }

    @Test
    void setNameShouldUpdateNameSuccessfully() {
        CityModel city = new CityModel();
        city.setName("NewName");

        assertEquals("NewName", city.getName());
    }

    @Test
    void setNameShouldThrowExceptionWhenNameExceedsMaxSize() {
        CityModel city = new CityModel();
        String longName = "A".repeat(CITY_FIELD_NAME_MAX_SIZE + 1);

        assertThrows(CityNameMaxSizeExceededException.class, () -> city.setName(longName));
    }

    @Test
    void setDescriptionShouldUpdateDescriptionSuccessfully() {
        CityModel city = new CityModel();
        city.setDescription("NewDescription");

        assertEquals("NewDescription", city.getDescription());
    }

    @Test
    void setDescriptionShouldThrowExceptionWhenDescriptionExceedsMaxSize() {
        CityModel city = new CityModel();
        String longDescription = "A".repeat(CITY_FIELD_DESCRIPTION_MAX_SIZE + 1);

        assertThrows(CityDescriptionMaxSizeExceededException.class, () -> city.setDescription(longDescription));
    }

    @Test
    void setDepartmentShouldUpdateDepartmentSuccessfully() {
        CityModel city = new CityModel();
        DepartmentModel department = mock(DepartmentModel.class);

        city.setDepartment(department);

        assertEquals(department, city.getDepartment());
    }

    @Test
    void setIdShouldUpdateIdSuccessfully() {
        CityModel city = new CityModel();
        city.setId(1L);

        assertEquals(1L, city.getId());
    }

    @Test
    void setNameShouldThrowExceptionWhenNameIsBlank() {
        CityModel city = new CityModel();
        assertThrows(EmptyFieldException.class, () -> city.setName(" "));
    }

    @Test
    void setDescriptionShouldThrowExceptionWhenDescriptionIsBlank() {
        CityModel city = new CityModel();
        assertThrows(EmptyFieldException.class, () -> city.setDescription(" "));
    }

}