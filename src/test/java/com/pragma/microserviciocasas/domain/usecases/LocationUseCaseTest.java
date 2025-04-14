package com.pragma.microserviciocasas.domain.usecases;

import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.domain.exceptions.InvalidPageOrSizeException;
import com.pragma.microserviciocasas.domain.exceptions.LocationAlreadyExistsException;
import com.pragma.microserviciocasas.domain.models.CityModel;
import com.pragma.microserviciocasas.domain.models.LocationModel;
import com.pragma.microserviciocasas.domain.ports.out.CategoryPersistencePort;
import com.pragma.microserviciocasas.domain.ports.out.LocationPersistencePort;
import com.pragma.microserviciocasas.domain.utils.PageResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LocationUseCaseTest {

    @Mock
    private LocationPersistencePort locationPersistencePort;

    @InjectMocks
    private LocationUseCase locationUseCase;

    @BeforeEach
    void setUp() {
        // Configuración inicial si es necesaria
    }

    @Test
    void saveLocation_ShouldSave_WhenLocationDoesNotExist() {
        // Arrange
        LocationModel locationModel = new LocationModel(1L, "Sector 1", new CityModel());
        locationModel.setSector("Sector 1");
        CityModel cityModel = new CityModel();
        cityModel.setId(1L); // Configurar el id
        locationModel.setCity(cityModel);

        when(locationPersistencePort.existsBySectorAndCityId("Sector 1", 1L)).thenReturn(false);

        // Act
        locationUseCase.saveLocation(locationModel);

        // Assert
        verify(locationPersistencePort, times(1)).saveLocation(locationModel);
    }

    @Test
    void saveLocation_ShouldThrowException_WhenLocationAlreadyExists() {
        // Arrange
        LocationModel locationModel = new LocationModel(1L, "Sector 1", new CityModel());
        locationModel.setSector("Sector 1");
        CityModel cityModel = new CityModel();
        cityModel.setId(1L); // Configurar el id
        locationModel.setCity(cityModel);

        when(locationPersistencePort.existsBySectorAndCityId("Sector 1", 1L)).thenReturn(true);

        // Act & Assert
        assertThrows(LocationAlreadyExistsException.class, () -> locationUseCase.saveLocation(locationModel));
        verify(locationPersistencePort, never()).saveLocation(locationModel);
    }

    @Test
    void searchLocations_ShouldThrowException_WhenTextIsNullOrBlank() {
        // Act & Assert
        assertThrows(EmptyFieldException.class, () -> locationUseCase.searchLocations(null, 0, 10, true));
        assertThrows(EmptyFieldException.class, () -> locationUseCase.searchLocations("", 0, 10, true));
        assertThrows(EmptyFieldException.class, () -> locationUseCase.searchLocations("   ", 0, 10, true));
    }

    @Test
    void searchLocations_ShouldThrowException_WhenPageOrSizeIsInvalid() {
        // Act & Assert
        assertThrows(InvalidPageOrSizeException.class, () -> locationUseCase.searchLocations("text", -1, 10, true));
        assertThrows(InvalidPageOrSizeException.class, () -> locationUseCase.searchLocations("text", 0, 0, true));
    }

    @Test
    void searchLocations_ShouldReturnResults_WhenValidParameters() {
        // Arrange
        PageResult<LocationModel> pageResult = new PageResult<>(new ArrayList<>(), 0, 10, true, 0L, 1);
        when(locationPersistencePort.searchLocations("text", 0, 10, true)).thenReturn(pageResult);

        // Act
        PageResult<LocationModel> result = locationUseCase.searchLocations("text", 0, 10, true);

        // Assert
        assertNotNull(result);
        verify(locationPersistencePort, times(1)).searchLocations("text", 0, 10, true);
    }
}