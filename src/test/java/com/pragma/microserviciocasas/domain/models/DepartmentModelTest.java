package com.pragma.microserviciocasas.domain.models;

import com.pragma.microserviciocasas.domain.exceptions.DepartmentDescriptionMaxSizeExceededException;
import com.pragma.microserviciocasas.domain.exceptions.DepartmentNameMaxSizeExceededException;
import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import org.junit.jupiter.api.Test;

import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.DEPARTMENT_FIELD_DESCRIPTION_MAX_SIZE;
import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.DEPARTMENT_FIELD_NAME_MAX_SIZE;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentModelTest {

    @Test
    void constructorShouldCreateDepartmentModelSuccessfully() {
        DepartmentModel department = new DepartmentModel(1L, "DepartmentName", "DepartmentDescription");

        assertEquals(1L, department.getId());
        assertEquals("DepartmentName", department.getName());
        assertEquals("DepartmentDescription", department.getDescription());
    }

    @Test
    void constructorShouldThrowExceptionWhenNameExceedsMaxSize() {
        String longName = "A".repeat(DEPARTMENT_FIELD_NAME_MAX_SIZE + 1);

        assertThrows(DepartmentNameMaxSizeExceededException.class, () ->
                new DepartmentModel(1L, longName, "Description")
        );
    }

    @Test
    void constructorShouldThrowExceptionWhenDescriptionExceedsMaxSize() {
        String longDescription = "A".repeat(DEPARTMENT_FIELD_DESCRIPTION_MAX_SIZE + 1);

        assertThrows(DepartmentDescriptionMaxSizeExceededException.class, () ->
                new DepartmentModel(1L, "Name", longDescription)
        );
    }

    @Test
    void constructorShouldThrowExceptionWhenNameIsBlank() {
        assertThrows(EmptyFieldException.class, () ->
                new DepartmentModel(1L, " ", "Description")
        );
    }

    @Test
    void constructorShouldThrowExceptionWhenDescriptionIsBlank() {
        assertThrows(EmptyFieldException.class, () ->
                new DepartmentModel(1L, "Name", " ")
        );
    }

    @Test
    void setNameShouldUpdateNameSuccessfully() {
        DepartmentModel department = new DepartmentModel();
        department.setName("NewName");

        assertEquals("NewName", department.getName());
    }

    @Test
    void setNameShouldThrowExceptionWhenNameExceedsMaxSize() {
        DepartmentModel department = new DepartmentModel();
        String longName = "A".repeat(DEPARTMENT_FIELD_NAME_MAX_SIZE + 1);

        assertThrows(DepartmentNameMaxSizeExceededException.class, () -> department.setName(longName));
    }

    @Test
    void setDescriptionShouldUpdateDescriptionSuccessfully() {
        DepartmentModel department = new DepartmentModel();
        department.setDescription("NewDescription");

        assertEquals("NewDescription", department.getDescription());
    }

    @Test
    void setDescriptionShouldThrowExceptionWhenDescriptionExceedsMaxSize() {
        DepartmentModel department = new DepartmentModel();
        String longDescription = "A".repeat(DEPARTMENT_FIELD_DESCRIPTION_MAX_SIZE + 1);

        assertThrows(DepartmentDescriptionMaxSizeExceededException.class, () -> department.setDescription(longDescription));
    }

    @Test
    void setIdShouldUpdateIdSuccessfully() {
        DepartmentModel department = new DepartmentModel();
        department.setId(1L);

        assertEquals(1L, department.getId());
    }

    @Test
    void setNameShouldThrowExceptionWhenNameIsBlank() {
        DepartmentModel department = new DepartmentModel();
        assertThrows(EmptyFieldException.class, () -> department.setName(" "));
    }

    @Test
    void setDescriptionShouldThrowExceptionWhenDescriptionIsBlank() {
        DepartmentModel department = new DepartmentModel();
        assertThrows(EmptyFieldException.class, () -> department.setDescription(" "));
    }
}