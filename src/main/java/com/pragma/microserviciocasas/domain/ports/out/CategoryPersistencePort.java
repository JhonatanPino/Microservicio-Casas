package com.pragma.microserviciocasas.domain.ports.out;

import com.pragma.microserviciocasas.domain.models.CategoryModel;
import com.pragma.microserviciocasas.domain.utils.PageResult;

public interface CategoryPersistencePort {

    void saveCategory(CategoryModel categoryModel);

    CategoryModel getCategoryByName(String categoryName);

    PageResult<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);

}
