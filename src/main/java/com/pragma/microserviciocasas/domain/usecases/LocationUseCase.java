package com.pragma.microserviciocasas.domain.usecases;

import com.pragma.microserviciocasas.domain.exceptions.LocationAlreadyExistsException;
import com.pragma.microserviciocasas.domain.models.LocationModel;
import com.pragma.microserviciocasas.domain.ports.in.LocationServicePort;
import com.pragma.microserviciocasas.domain.ports.out.LocationPersistencePort;

public class LocationUseCase implements LocationServicePort {
    private final LocationPersistencePort locationPersistencePort;

    public LocationUseCase(LocationPersistencePort locationPersistencePort) {
        this.locationPersistencePort = locationPersistencePort;
    }

    @Override
    public void saveLocation(LocationModel locationModel) {
        boolean location = locationPersistencePort.existsBySectorAndCityId(locationModel.getSector(), locationModel.getCity().getId());

        if (location) {
            throw new LocationAlreadyExistsException();
        }

        locationPersistencePort.saveLocation(locationModel);
    }

}

