package com.pragma.microserviciocasas.infrastructure.endpoints.rest;

import com.pragma.microserviciocasas.application.dto.request.SaveCategoryRequest;
import com.pragma.microserviciocasas.application.dto.response.CategoryResponse;
import com.pragma.microserviciocasas.application.dto.response.SaveCategoryResponse;
import com.pragma.microserviciocasas.application.services.CategoryService;
import com.pragma.microserviciocasas.domain.exceptions.CategoryAlreadyExistsException;
import com.pragma.microserviciocasas.domain.exceptions.InvalidPageOrSizeException;
import com.pragma.microserviciocasas.domain.utils.PageResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.pragma.microserviciocasas.commons.configurations.utils.Constants.*;
import static com.pragma.microserviciocasas.infrastructure.exceptionshandler.ExceptionConstants.CATEGORY_EXISTS_EXCEPTION;
import static com.pragma.microserviciocasas.infrastructure.exceptionshandler.ExceptionConstants.INVALID_PAGE_OR_SIZE;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @Operation(summary = "Save a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = STATUS_CREATE, description = SAVE_CATEGORY_RESPONSE_MESSAGE),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = CATEGORY_EXISTS_EXCEPTION,
                    content = @Content(schema = @Schema(implementation = CategoryAlreadyExistsException.class))),
    })
    @PostMapping("/")
    public ResponseEntity<SaveCategoryResponse> createCategory(@RequestBody SaveCategoryRequest saveCategoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveCategory(saveCategoryRequest));
    }

    @Operation(summary = "Get all categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = STATUS_OK, description = CATEGORY_RETRIEVED,
                    content = @Content(schema = @Schema(implementation = PageResult.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = INVALID_PAGE_OR_SIZE,
                    content = @Content(schema = @Schema(implementation = InvalidPageOrSizeException.class))),
    })
    @GetMapping("/")
    public ResponseEntity<PageResult<CategoryResponse>> getAllCategories(@RequestParam Integer page,
                                                                         @RequestParam Integer size,
                                                                         @RequestParam boolean orderAsc) {
        return ResponseEntity.ok(categoryService.getCategories(page, size, orderAsc));
    }
}


/*
SaveCategoryResponse es una clase de registro en Java que representa la respuesta devuelta tras guardar una categoría.
 ResponseEntity<SaveCategoryResponse>: El método devuelve una ResponseEntity que contiene un objeto SaveCategoryResponse.
 ResponseEntity se utiliza para representar la respuesta HTTP completa, incluyendo el código de estado, los encabezados y el cuerpo.
 save: El nombre del método.
 @RequestBody SaveCategoryRequest saveCategoryRequest: El método toma un único parámetro, saveCategoryRequest,
 anotado con @RequestBody. Esta anotación indica que el parámetro debe estar vinculado al cuerpo de la solicitud HTTP y
 es de tipo SaveCategoryRequest.

 Este método gestiona solicitudes HTTP GET para obtener una lista paginada de categorías.
@GetMapping("/"): Asigna solicitudes HTTP GET a la URL raíz del controlador (/api/v1/category/).
public ResponseEntity<PageResult<CategoryResponse>> getAllCategories(...): Define el método getAllCategories, que devuelve
una ResponseEntity que contiene un PageResult de CategoryResponse.
@RequestParam Integer page, @RequestParam Integer size, @RequestParam boolean orderAsc: El método toma tres parámetros
 de consulta: page, size y orderAsc.
return ResponseEntity.ok(categoryService.getCategories(page, size, orderAsc)): Llama al método getCategories de categoryService
con los parámetros proporcionados y devuelve el resultado envuelto en una ResponseEntity con estado HTTP 200 (OK).
 */