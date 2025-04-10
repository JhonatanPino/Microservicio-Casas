package com.pragma.microserviciocasas.domain.ports.out;

import com.pragma.microserviciocasas.domain.models.LocationModel;

public interface LocationPersistencePort {

    void saveLocation(LocationModel locationModel);

    //LocationModel getLocationById(Long id);
}
