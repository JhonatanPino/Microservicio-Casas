package com.pragma.microserviciocasas.infrastructure.exceptionshandler;

import com.pragma.microserviciocasas.domain.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

    // Category
    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.CATEGORY_EXISTS_EXCEPTION,
                LocalDateTime.now()));
    }

    @ExceptionHandler(CategoryNameMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleNameMaxSizeExceededException(CategoryNameMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.CATEGORY_NAME_MAX_SIZE_MESSAGE,
                LocalDateTime.now()));
    }

    @ExceptionHandler(CategoryDescriptionMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleDescriptionMaxSizeExceededException(CategoryDescriptionMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.CATEGORY_DESCRIPTION_MAX_SIZE_MESSAGE,
                LocalDateTime.now()));
    }

    @ExceptionHandler(InvalidPageOrSizeException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidPageOrSize(InvalidPageOrSizeException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.INVALID_PAGE_OR_SIZE,
                LocalDateTime.now()));
    }

    // Department
    @ExceptionHandler(DepartmentAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleDepartmentAlreadyExistsException(DepartmentAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.DEPARTMENT_EXISTS_EXCEPTION,
                LocalDateTime.now()));
    }

    @ExceptionHandler(DepartmentNameMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleDepartmentNameMaxSizeExceededException(DepartmentNameMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.DEPARTMENT_NAME_MAX_SIZE_MESSAGE,
                LocalDateTime.now()));
    }

    @ExceptionHandler(DepartmentDescriptionMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleDepartmentDescriptionMaxSizeExceededException(DepartmentDescriptionMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.DEPARTMENT_DESCRIPTION_MAX_SIZE_MESSAGE,
                LocalDateTime.now()));
    }

    // City
    @ExceptionHandler(CityAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleCityAlreadyExistsException(CityAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.CITY_EXISTS_EXCEPTION,
                LocalDateTime.now()));
    }

    @ExceptionHandler(CityNameMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleCityNameMaxSizeExceededException(CityNameMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.CITY_NAME_MAX_SIZE_MESSAGE,
                LocalDateTime.now()));
    }

    @ExceptionHandler(CityDescriptionMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleCityDescriptionMaxSizeExceededException(CityDescriptionMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.CITY_DESCRIPTION_MAX_SIZE_MESSAGE,
                LocalDateTime.now()));
    }

    // General
    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<ExceptionResponse> handleEmptyFieldException(EmptyFieldException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.FIELD_CANNOT_EMPTY_MESSAGE,
                LocalDateTime.now()));
    }

}
