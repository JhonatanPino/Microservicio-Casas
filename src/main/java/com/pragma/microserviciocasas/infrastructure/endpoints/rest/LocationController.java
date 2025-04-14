package com.pragma.microserviciocasas.infrastructure.endpoints.rest;

import com.pragma.microserviciocasas.application.dto.request.SaveLocationRequest;
import com.pragma.microserviciocasas.application.dto.response.LocationResponse;
import com.pragma.microserviciocasas.application.dto.response.SaveLocationResponse;
import com.pragma.microserviciocasas.application.services.LocationService;
import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.domain.exceptions.InvalidPageOrSizeException;
import com.pragma.microserviciocasas.domain.exceptions.LocationAlreadyExistsException;
import com.pragma.microserviciocasas.domain.exceptions.LocationSectorMaxSizeExceededException;
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
@RequestMapping("/api/v1/locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @Operation(summary = "Save a new location")
    @ApiResponses(value = {
            @ApiResponse(responseCode = STATUS_CREATE, description = SAVE_LOCATION_RESPONSE_MESSAGE),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = LOCATION_EXISTS_EXCEPTION,
                    content = @Content(schema = @Schema(implementation = LocationAlreadyExistsException.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = LOCATION_SECTOR_MAX_SIZE_MESSAGE,
                    content = @Content(schema = @Schema(implementation = LocationSectorMaxSizeExceededException.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = FIELD_CANNOT_EMPTY_MESSAGE,
                    content = @Content(schema = @Schema(implementation = EmptyFieldException.class))),
    })
    @PostMapping("/")
    public ResponseEntity<SaveLocationResponse> createLocation(@RequestBody SaveLocationRequest saveLocationRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.saveLocation(saveLocationRequest));
    }

    @Operation(summary = "Search locations for city or department")
    @ApiResponses(value = {
            @ApiResponse(responseCode = STATUS_OK, description = LOCATION_RETRIEVED,
                    content = @Content(schema = @Schema(implementation = PageResult.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = INVALID_PAGE_OR_SIZE,
                    content = @Content(schema = @Schema(implementation = InvalidPageOrSizeException.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = FIELD_CANNOT_EMPTY_MESSAGE,
                    content = @Content(schema = @Schema(implementation = EmptyFieldException.class))),
    })
    @GetMapping("/search")
    public ResponseEntity <PageResult<LocationResponse>> searchLocations( @RequestParam String text,
                                                                          @RequestParam int page,
                                                                          @RequestParam int size,
                                                                          @RequestParam boolean orderAsc) {
        return ResponseEntity.ok(locationService.searchLocations(text, page, size, orderAsc));
    }
}

