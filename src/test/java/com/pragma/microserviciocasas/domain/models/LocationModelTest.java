package com.pragma.microserviciocasas.domain.models;

import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.domain.exceptions.LocationSectorMaxSizeExceededException;
import org.junit.jupiter.api.Test;

import static com.pragma.microserviciocasas.domain.utils.constants.DomainConstants.LOCATION_FIELD_SECTOR_MAX_SIZE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LocationModelTest {

    @Test
    void constructorShouldCreateLocationModelSuccessfully() {
        CityModel city = mock(CityModel.class);
        LocationModel location = new LocationModel(1L, "SectorName", city);

        assertEquals(1L, location.getId());
        assertEquals("SectorName", location.getSector());
        assertEquals(city, location.getCity());
    }

    @Test
    void constructorShouldThrowExceptionWhenSectorExceedsMaxSize() {
        CityModel city = mock(CityModel.class);
        String longSector = "A".repeat(LOCATION_FIELD_SECTOR_MAX_SIZE + 1);

        assertThrows(LocationSectorMaxSizeExceededException.class, () ->
                new LocationModel(1L, longSector, city)
        );
    }

    @Test
    void constructorShouldThrowExceptionWhenSectorIsBlank() {
        CityModel city = mock(CityModel.class);

        assertThrows(EmptyFieldException.class, () ->
                new LocationModel(1L, " ", city)
        );
    }

    @Test
    void constructorShouldThrowExceptionWhenCityIsNull() {
        assertThrows(NullPointerException.class, () ->
                new LocationModel(1L, "SectorName", null)
        );
    }

    @Test
    void setSectorShouldUpdateSectorSuccessfully() {
        LocationModel location = new LocationModel(1L, "OldSector", mock(CityModel.class));
        location.setSector("NewSector");

        assertEquals("NewSector", location.getSector());
    }

    @Test
    void setSectorShouldThrowExceptionWhenSectorExceedsMaxSize() {
        LocationModel location = new LocationModel(1L, "OldSector", mock(CityModel.class));
        String longSector = "A".repeat(LOCATION_FIELD_SECTOR_MAX_SIZE + 1);

        assertThrows(LocationSectorMaxSizeExceededException.class, () -> location.setSector(longSector));
    }

    @Test
    void setSectorShouldThrowExceptionWhenSectorIsBlank() {
        LocationModel location = new LocationModel(1L, "OldSector", mock(CityModel.class));

        assertThrows(EmptyFieldException.class, () -> location.setSector(" "));
    }

    @Test
    void setCityShouldUpdateCitySuccessfully() {
        LocationModel location = new LocationModel(1L, "SectorName", mock(CityModel.class));
        CityModel newCity = mock(CityModel.class);

        location.setCity(newCity);

        assertEquals(newCity, location.getCity());
    }

    @Test
    void setCityShouldThrowExceptionWhenCityIsNull() {
        LocationModel location = new LocationModel(1L, "SectorName", mock(CityModel.class));

        assertThrows(NullPointerException.class, () -> location.setCity(null));
    }
}