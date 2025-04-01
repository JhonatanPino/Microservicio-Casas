package com.pragma.microserviciocasas.category.domain.ports.in;

import com.pragma.microserviciocasas.category.domain.models.CategoryModel;
import com.pragma.microserviciocasas.category.domain.utils.PageResult;

public interface CategoryServicePort {

    void save(CategoryModel categoryModel);

    PageResult<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);

}
