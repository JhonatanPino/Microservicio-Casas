package com.pragma.microserviciocasas.domain.usecases;

import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.domain.exceptions.InvalidPageOrSizeException;
import com.pragma.microserviciocasas.domain.exceptions.LocationAlreadyExistsException;
import com.pragma.microserviciocasas.domain.models.LocationModel;
import com.pragma.microserviciocasas.domain.ports.in.LocationServicePort;
import com.pragma.microserviciocasas.domain.ports.out.LocationPersistencePort;
import com.pragma.microserviciocasas.domain.utils.PageResult;

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

    @Override
    public PageResult<LocationModel> searchLocations(String text, Integer page, Integer size, boolean orderAsc) {
        if (text == null || text.isBlank()) {
            throw new EmptyFieldException();
        }
        if (page < 0 || size <= 0) {
            throw new InvalidPageOrSizeException();
        }

        return locationPersistencePort.searchLocations(text, page, size, orderAsc);
    }

}

