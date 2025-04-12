package com.pragma.microserviciocasas.domain.ports.in;

import com.pragma.microserviciocasas.domain.models.LocationModel;

public interface LocationServicePort {

    void saveLocation(LocationModel locationModel);
}
