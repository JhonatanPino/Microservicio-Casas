package com.pragma.microserviciocasas.domain.models;

import com.pragma.microserviciocasas.domain.exceptions.CategoryDescriptionMaxSizeExceededException;
import com.pragma.microserviciocasas.domain.exceptions.CategoryNameMaxSizeExceededException;
import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.domain.utils.constants.DomainConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryModelTest {

    @Mock
    private CategoryModel categoryModel;

    @BeforeEach
    void setUp() {
        categoryModel = new CategoryModel(1L, "CategoryName", "CategoryDescription");
    }

    @Test
    void testNameExceedsMaxSize() {
        String longName = "a".repeat(DomainConstants.FIELD_NAME_MAX_SIZE + 1);
        assertThrows(CategoryNameMaxSizeExceededException.class, () -> new CategoryModel(1L, longName, "Description"));
    }

    @Test
    void testNameIsEmpty() {
        assertThrows(EmptyFieldException.class, () -> new CategoryModel(1L, "", "Description"));
    }

    @Test
    void testDescriptionExceedsMaxSize() {
        String longDescription = "a".repeat(DomainConstants.CATEGORY_FIELD_DESCRIPTION_MAX_SIZE + 1);
        assertThrows(CategoryDescriptionMaxSizeExceededException.class, () -> new CategoryModel(1L, "Name", longDescription));
    }

    @Test
    void testDescriptionIsEmpty() {
        assertThrows(EmptyFieldException.class, () -> new CategoryModel(1L, "Name", ""));
    }

    @Test
    void testSetNameExceedsMaxSize() {
        CategoryModel categoryModel = new CategoryModel(1L, "Name", "Description");
        String longName = "a".repeat(DomainConstants.FIELD_NAME_MAX_SIZE + 1);
        assertThrows(CategoryNameMaxSizeExceededException.class, () -> categoryModel.setName(longName));
    }

    @Test
    void testSetNameIsEmpty() {
        CategoryModel categoryModel = new CategoryModel(1L, "Name", "Description");
        assertThrows(EmptyFieldException.class, () -> categoryModel.setName(""));
    }

    @Test
    void testSetDescriptionExceedsMaxSize() {
        CategoryModel categoryModel = new CategoryModel(1L, "Name", "Description");
        String longDescription = "a".repeat(DomainConstants.CATEGORY_FIELD_DESCRIPTION_MAX_SIZE + 1);
        assertThrows(CategoryDescriptionMaxSizeExceededException.class, () -> categoryModel.setDescription(longDescription));
    }

    @Test
    void testSetDescriptionIsEmpty() {
        CategoryModel categoryModel = new CategoryModel(1L, "Name", "Description");
        assertThrows(EmptyFieldException.class, () -> categoryModel.setDescription(""));
    }

    @Test
    void getId() {
        assertEquals(1L, categoryModel.getId());
    }

    @Test
    void getName() {
        assertEquals("CategoryName", categoryModel.getName());
    }

    @Test
    void getDescription() {
        assertEquals("CategoryDescription", categoryModel.getDescription());
    }

    @Test
    void setName() {
        categoryModel.setName("NewName");
        assertEquals("NewName", categoryModel.getName());
    }

    @Test
    void setDescription() {
        categoryModel.setDescription("NewDescription");
        assertEquals("NewDescription", categoryModel.getDescription());
    }
}
