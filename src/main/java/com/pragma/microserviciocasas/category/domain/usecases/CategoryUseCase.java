package com.pragma.microserviciocasas.category.domain.usecases;

import com.pragma.microserviciocasas.category.domain.exceptions.CategoryAlreadyExistsException;
import com.pragma.microserviciocasas.category.domain.model.CategoryModel;
import com.pragma.microserviciocasas.category.domain.utils.PagedResult;
import com.pragma.microserviciocasas.category.domain.ports.in.CategoryServicePort;
import com.pragma.microserviciocasas.category.domain.ports.out.CategoryPersistencePort;

public class CategoryUseCase implements CategoryServicePort {
    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase (CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void save(CategoryModel categoryModel) {
        CategoryModel category = categoryPersistencePort.getCategoryByName(categoryModel.getName());

        if (category != null) {
            throw new CategoryAlreadyExistsException();
        }
        categoryPersistencePort.save(categoryModel);
    }

    @Override
    public PagedResult<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        return categoryPersistencePort.getCategories(page, size, orderAsc);
    }
}
