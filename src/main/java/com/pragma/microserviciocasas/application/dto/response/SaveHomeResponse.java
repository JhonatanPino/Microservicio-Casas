package com.pragma.microserviciocasas.application.dto.response;

import java.time.LocalDateTime;

public record SaveHomeResponse(String message, LocalDateTime time) {
}
