package com.pragma.microserviciocasas.domain.usecases;

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
        if (locationModel == null) {
            throw new IllegalArgumentException("El modelo de ubicación no puede ser nulo");
        }
        if (locationModel.getCity() == null || locationModel.getCity().getId() == null) {
            throw new IllegalArgumentException("La ubicación debe estar asociada a una ciudad válida");
        }

        locationPersistencePort.saveLocation(locationModel);
    }

}

