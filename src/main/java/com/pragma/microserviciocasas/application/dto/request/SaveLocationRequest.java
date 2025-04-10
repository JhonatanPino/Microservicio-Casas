package com.pragma.microserviciocasas.application.dto.request;

import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.domain.exceptions.IdCannotBeNullException;
import com.pragma.microserviciocasas.domain.exceptions.LocationSectorMaxSizeExceededException;

import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.LOCATION_FIELD_SECTOR_MAX_SIZE;


public record SaveLocationRequest(String sector, Long idCity) {
    public SaveLocationRequest {
        if(sector.length() > LOCATION_FIELD_SECTOR_MAX_SIZE){
            throw new LocationSectorMaxSizeExceededException();
        }
        if (sector.isBlank()) {
            throw new EmptyFieldException();
        }
        if (idCity == null || idCity <= 0) {
            throw new IdCannotBeNullException();
        }
    }

    public Long getIdCity() { return idCity; }

}
