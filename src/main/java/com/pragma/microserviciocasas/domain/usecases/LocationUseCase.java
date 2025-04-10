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

        locationPersistencePort.saveLocation(locationModel);
    }

}

// Aquí puedes agregar la lógica de negocio relacionada con las ubicaciones.
// Por ejemplo, podrías implementar métodos para guardar, actualizar o eliminar ubicaciones.
// También podrías implementar métodos para obtener ubicaciones por diferentes criterios.

// Ejemplo de un método que podría estar aquí:
// public LocationModel getLocationById(Long id) {
//     return locationPersistencePort.getLocationById(id);
// }
