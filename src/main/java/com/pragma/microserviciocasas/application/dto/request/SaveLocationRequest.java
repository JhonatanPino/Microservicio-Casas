package com.pragma.microserviciocasas.application.dto.request;

import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.domain.exceptions.IdCannotBeNullException;

public record SaveLocationRequest(String sector, Long idCity) {
    public SaveLocationRequest {
        if (sector == null || sector.isBlank()) {
            throw new EmptyFieldException();
        }
        if (idCity == null || idCity <= 0) {
            throw new IdCannotBeNullException();
        }
    }
}
