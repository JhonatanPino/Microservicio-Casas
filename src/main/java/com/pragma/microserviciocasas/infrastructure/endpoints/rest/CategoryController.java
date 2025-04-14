package com.pragma.microserviciocasas.infrastructure.endpoints.rest;

import com.pragma.microserviciocasas.application.dto.request.SaveCategoryRequest;
import com.pragma.microserviciocasas.application.dto.response.CategoryResponse;
import com.pragma.microserviciocasas.application.dto.response.SaveCategoryResponse;
import com.pragma.microserviciocasas.application.services.CategoryService;
import com.pragma.microserviciocasas.domain.exceptions.*;
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
import static com.pragma.microserviciocasas.infrastructure.exceptionshandler.ExceptionConstants.*;

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
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = CATEGORY_NAME_MAX_SIZE_MESSAGE,
                    content = @Content(schema = @Schema(implementation = CategoryNameMaxSizeExceededException.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = CATEGORY_DESCRIPTION_MAX_SIZE_MESSAGE,
                    content = @Content(schema = @Schema(implementation = CategoryDescriptionMaxSizeExceededException.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = FIELD_CANNOT_EMPTY_MESSAGE,
                    content = @Content(schema = @Schema(implementation = EmptyFieldException.class))),
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
