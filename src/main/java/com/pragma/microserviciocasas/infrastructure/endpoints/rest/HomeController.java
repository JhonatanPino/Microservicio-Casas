package com.pragma.microserviciocasas.infrastructure.endpoints.rest;

import com.pragma.microserviciocasas.application.dto.request.PublishHomeRequest;
import com.pragma.microserviciocasas.application.dto.response.HomeResponse;
import com.pragma.microserviciocasas.application.dto.response.SaveHomeResponse;
import com.pragma.microserviciocasas.application.services.HomeService;
import com.pragma.microserviciocasas.domain.exceptions.*;
import com.pragma.microserviciocasas.domain.utils.PageResult;
import com.pragma.microserviciocasas.infrastructure.entities.HomeEntity;
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
import static com.pragma.microserviciocasas.commons.configurations.utils.Constants.STATUS_BAD_REQUEST;
import static com.pragma.microserviciocasas.infrastructure.exceptionshandler.ExceptionConstants.*;

@RestController
@RequestMapping("/api/v1/lhomes")
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;

    @Operation(summary = "Publish a new home")
    @ApiResponses(value = {
            @ApiResponse(responseCode = STATUS_CREATE, description = PUBLISH_HOME_RESPONSE_MESSAGE,
                    content = @Content(schema = @Schema(implementation = SaveHomeResponse.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = HOME_EXISTS_EXCEPTION,
                    content = @Content(schema = @Schema(implementation = HomeAlreadyExistsException.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = INVALID_NUMBER_MESSAGE,
                    content = @Content(schema = @Schema(implementation = InvalidNumberException.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = HOME_PUBLICATION_DATE_ACTIVE_MESSAGE,
                    content = @Content(schema = @Schema(implementation = InvalidPublicationDateActiveException.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = FIELD_CANNOT_EMPTY_MESSAGE,
                    content = @Content(schema = @Schema(implementation = EmptyFieldException.class))),
    })
    @PostMapping("/")
    public ResponseEntity<SaveHomeResponse> publisHome(@RequestBody PublishHomeRequest publishHomeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(homeService.publisHome(publishHomeRequest));
    }

    @Operation(summary = "Search homes for sector, category, rooms, bathrooms or price")
    @GetMapping("/")
    public ResponseEntity<PageResult<HomeResponse>> searchHomes(@RequestParam String text,
                                                                @RequestParam int page,
                                                                @RequestParam int size,
                                                                @RequestParam boolean orderAsc) {
        return ResponseEntity.ok(homeService.searchHomes(text, page, size, orderAsc));
    }
}
