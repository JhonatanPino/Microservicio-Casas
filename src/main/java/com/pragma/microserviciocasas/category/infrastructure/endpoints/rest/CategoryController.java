package com.pragma.microserviciocasas.category.infrastructure.endpoints.rest;

import com.pragma.microserviciocasas.category.application.dto.request.SaveCategoryRequest;
import com.pragma.microserviciocasas.category.application.dto.response.CategoryResponse;
import com.pragma.microserviciocasas.category.application.dto.response.SaveCategoryResponse;
import com.pragma.microserviciocasas.category.application.services.CategoryService;
import com.pragma.microserviciocasas.category.domain.utils.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<SaveCategoryResponse> save(@RequestBody SaveCategoryRequest saveCategoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(saveCategoryRequest));
    }

    @GetMapping("/")
    public ResponseEntity<PageResult<CategoryResponse>> getAllCategories(@RequestParam Integer page,
                                                                         @RequestParam Integer size,
                                                                         @RequestParam boolean orderAsc) {
        return ResponseEntity.ok(categoryService.getCategories(page, size, orderAsc));
    }
    
}
