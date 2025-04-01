package com.pragma.microserviciocasas.category.application.services;

import com.pragma.microserviciocasas.category.application.dto.request.SaveCategoryRequest;
import com.pragma.microserviciocasas.category.application.dto.response.CategoryResponse;
import com.pragma.microserviciocasas.category.application.dto.response.SaveCategoryResponse;
import com.pragma.microserviciocasas.category.domain.utils.PageResult;

public interface CategoryService {
    SaveCategoryResponse save(SaveCategoryRequest request);

    PageResult<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc);
}
