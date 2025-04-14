package com.pragma.microserviciocasas.infrastructure.endpoints.rest;

import com.pragma.microserviciocasas.application.dto.request.SaveLocationRequest;
import com.pragma.microserviciocasas.application.dto.response.LocationResponse;
import com.pragma.microserviciocasas.application.dto.response.SaveLocationResponse;
import com.pragma.microserviciocasas.application.services.LocationService;
import com.pragma.microserviciocasas.domain.exceptions.LocationAlreadyExistsException;
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
import static com.pragma.microserviciocasas.infrastructure.exceptionshandler.ExceptionConstants.LOCATION_EXISTS_EXCEPTION;

@RestController
@RequestMapping("/api/v1/locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @Operation(summary = "Save a new location")
    @ApiResponses(value = {
            @ApiResponse(responseCode = STATUS_CREATE, description = SAVE_LOCATION_RESPONSE_MESSAGE),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = LOCATION_EXISTS_EXCEPTION,
                    content = @Content(schema = @Schema(implementation = LocationAlreadyExistsException.class))),
    })
    @PostMapping("/")
    public ResponseEntity<SaveLocationResponse> createLocation(@RequestBody SaveLocationRequest saveLocationRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.saveLocation(saveLocationRequest));
    }

    @Operation(summary = "Get all locations")
    @GetMapping("/search")
    public ResponseEntity <PageResult<LocationResponse>> searchLocations( @RequestParam String text,
                                                                          @RequestParam int page,
                                                                          @RequestParam int size,
                                                                          @RequestParam boolean orderAsc) {
        return ResponseEntity.ok(locationService.searchLocations(text, page, size, orderAsc));
    }
}

