package com.pragma.microserviciocasas.application.services;

import com.pragma.microserviciocasas.application.dto.request.SaveCategoryRequest;
import com.pragma.microserviciocasas.application.dto.response.CategoryResponse;
import com.pragma.microserviciocasas.application.dto.response.SaveCategoryResponse;
import com.pragma.microserviciocasas.domain.utils.PageResult;

public interface CategoryService {
    SaveCategoryResponse saveCategory(SaveCategoryRequest request);

    PageResult<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc);
}
