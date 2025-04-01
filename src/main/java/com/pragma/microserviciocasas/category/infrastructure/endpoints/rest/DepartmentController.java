package com.pragma.microserviciocasas.category.infrastructure.endpoints.rest;

import com.pragma.microserviciocasas.category.application.dto.request.SaveDepartmentRequest;
import com.pragma.microserviciocasas.category.application.dto.response.DepartmentResponse;
import com.pragma.microserviciocasas.category.application.dto.response.SaveDepartmentResponse;
import com.pragma.microserviciocasas.category.application.services.DepartmentService;
import com.pragma.microserviciocasas.category.domain.utils.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<SaveDepartmentResponse> save(@RequestBody SaveDepartmentRequest saveDepartmentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.save(saveDepartmentRequest));
    }

    @GetMapping("/")
    public ResponseEntity<PageResult<DepartmentResponse>> getAllDepartments(@RequestParam Integer page,
                                                                            @RequestParam Integer size,
                                                                            @RequestParam boolean orderAsc) {
        return ResponseEntity.ok(departmentService.getDepartments(page, size, orderAsc));
    }
}
