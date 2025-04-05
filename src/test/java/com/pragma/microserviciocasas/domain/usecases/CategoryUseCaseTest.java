package com.pragma.microserviciocasas.domain.usecases;

import com.pragma.microserviciocasas.domain.exceptions.CategoryAlreadyExistsException;
import com.pragma.microserviciocasas.domain.exceptions.InvalidPageOrSizeException;
import com.pragma.microserviciocasas.domain.models.CategoryModel;
import com.pragma.microserviciocasas.domain.ports.out.CategoryPersistencePort;
import com.pragma.microserviciocasas.domain.utils.PageResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {

    @Mock
    private CategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;
    private CategoryModel categoryModel;

    @BeforeEach
    void setUp() {
        categoryModel = new CategoryModel(1L, "Test Category", "Test Description");
        categoryModel.setName("Test Category");
    }

    @Test
    void save_shouldSaveCategory_whenCategoryDoesNotExist() {
        when(categoryPersistencePort.getCategoryByName(categoryModel.getName())).thenReturn(null);

        categoryUseCase.saveCategory(categoryModel);

        verify(categoryPersistencePort, times(1)).saveCategory(categoryModel);
    }

    @Test
    void save_shouldThrowException_whenCategoryAlreadyExists() {
        when(categoryPersistencePort.getCategoryByName(categoryModel.getName())).thenReturn(categoryModel);

        assertThrows(CategoryAlreadyExistsException.class, () -> categoryUseCase.saveCategory(categoryModel));

        verify(categoryPersistencePort, never()).saveCategory(categoryModel);
    }

    @Test
    void getCategories_shouldReturnPageResult_whenValidPageAndSize() {
        int page = 0;
        int size = 10;
        boolean orderAsc = true;
        List<CategoryModel> categories = Arrays.asList(
                new CategoryModel(1L, "Category A", "Description A"),
                new CategoryModel(2L, "Category B", "Description B")
        );
        PageResult<CategoryModel> expectedPage = new PageResult<>(categories, 2, 1, true, 10, 2);

        when(categoryPersistencePort.getCategories(page, size, orderAsc)).thenReturn(expectedPage);

        PageResult<CategoryModel> actualPage = categoryUseCase.getCategories(page, size, orderAsc);

        assertEquals(expectedPage, actualPage);
        verify(categoryPersistencePort, times(1)).getCategories(page, size, orderAsc);
    }

    @Test
    void getCategories_shouldThrowInvalidPageOrSizeException_whenInvalidPage() {
        int page = -1;
        int size = 10;
        boolean orderAsc = true;

        assertThrows(InvalidPageOrSizeException.class, () -> categoryUseCase.getCategories(page, size, orderAsc));
        verify(categoryPersistencePort, never()).getCategories(anyInt(), anyInt(), anyBoolean());
    }

    @Test
    void getCategories_shouldThrowInvalidPageOrSizeException_whenInvalidSize() {
        int page = 0;
        int size = 0;
        boolean orderAsc = true;

        assertThrows(InvalidPageOrSizeException.class, () -> categoryUseCase.getCategories(page, size, orderAsc));
        verify(categoryPersistencePort, never()).getCategories(anyInt(), anyInt(), anyBoolean());
    }
}