package com.pragma.microserviciocasas.category.domain.ports.out;

import com.pragma.microserviciocasas.category.domain.models.CategoryModel;
import com.pragma.microserviciocasas.category.domain.utils.PageResult;

public interface CategoryPersistencePort {

    void save(CategoryModel categoryModel);

    CategoryModel getCategoryByName(String categoryName);

    PageResult<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);

}
