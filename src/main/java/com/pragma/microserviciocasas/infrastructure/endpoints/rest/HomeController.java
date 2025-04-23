package com.pragma.microserviciocasas.infrastructure.endpoints.rest;

import com.pragma.microserviciocasas.application.dto.request.PublishHomeRequest;
import com.pragma.microserviciocasas.application.dto.response.SaveHomeResponse;
import com.pragma.microserviciocasas.application.services.HomeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/lhomes")
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;

    @Operation(summary = "Publish a new home")
    @PostMapping("/")
    public ResponseEntity<SaveHomeResponse> publisHome(@RequestBody PublishHomeRequest publishHomeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(homeService.publisHome(publishHomeRequest));
    }
}
