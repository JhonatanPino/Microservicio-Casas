package com.pragma.microserviciocasas.category.domain.ports.in;

import com.pragma.microserviciocasas.category.domain.model.CategoryModel;
import com.pragma.microserviciocasas.category.domain.utils.PagedResult;

public interface CategoryServicePort {

    void save(CategoryModel categoryModel);

    PagedResult<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);

}
