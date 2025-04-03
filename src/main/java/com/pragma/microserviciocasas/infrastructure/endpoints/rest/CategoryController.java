package com.pragma.microserviciocasas.infrastructure.endpoints.rest;

import com.pragma.microserviciocasas.application.dto.request.SaveCategoryRequest;
import com.pragma.microserviciocasas.application.dto.response.CategoryResponse;
import com.pragma.microserviciocasas.application.dto.response.SaveCategoryResponse;
import com.pragma.microserviciocasas.application.services.CategoryService;
import com.pragma.microserviciocasas.domain.utils.PageResult;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveCategory(saveCategoryRequest));
    }

    @GetMapping("/")
    public ResponseEntity<PageResult<CategoryResponse>> getAllCategories(@RequestParam Integer page,
                                                                         @RequestParam Integer size,
                                                                         @RequestParam boolean orderAsc) {
        return ResponseEntity.ok(categoryService.getCategories(page, size, orderAsc));
    }
    
}

/*SaveCategoryResponse es una clase de registro en Java que representa la respuesta devuelta tras guardar una categoría.
 ResponseEntity<SaveCategoryResponse>: El método devuelve una ResponseEntity que contiene un objeto SaveCategoryResponse.
 ResponseEntity se utiliza para representar la respuesta HTTP completa, incluyendo el código de estado, los encabezados y el cuerpo.
 save: El nombre del método.
 @RequestBody SaveCategoryRequest saveCategoryRequest: El método toma un único parámetro, saveCategoryRequest,
 anotado con @RequestBody. Esta anotación indica que el parámetro debe estar vinculado al cuerpo de la solicitud HTTP y
 es de tipo SaveCategoryRequest.
 */