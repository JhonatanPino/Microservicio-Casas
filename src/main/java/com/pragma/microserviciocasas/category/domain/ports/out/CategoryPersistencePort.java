package com.pragma.microserviciocasas.category.domain.ports.out;

import com.pragma.microserviciocasas.category.domain.model.CategoryModel;
import com.pragma.microserviciocasas.category.domain.utils.PagedResult;

public interface CategoryPersistencePort {

    void save(CategoryModel categoryModel);

    CategoryModel getCategoryByName(String categoryName);

    PagedResult<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);

}
