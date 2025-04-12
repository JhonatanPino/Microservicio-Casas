package com.pragma.microserviciocasas.domain.ports.in;

import com.pragma.microserviciocasas.domain.models.CategoryModel;
import com.pragma.microserviciocasas.domain.utils.PageResult;

public interface CategoryServicePort {

    void saveCategory(CategoryModel categoryModel);

    PageResult<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);

}
