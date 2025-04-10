package com.pragma.microserviciocasas.infrastructure.endpoints.rest;

import com.pragma.microserviciocasas.application.dto.request.SaveLocationRequest;
import com.pragma.microserviciocasas.application.dto.response.SaveLocationResponse;
import com.pragma.microserviciocasas.application.services.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @Operation(summary = "Save a new location")
    @PostMapping("/")
    public ResponseEntity<SaveLocationResponse> createLocation(@RequestBody SaveLocationRequest saveLocationRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.saveLocation(saveLocationRequest));
    }
}
