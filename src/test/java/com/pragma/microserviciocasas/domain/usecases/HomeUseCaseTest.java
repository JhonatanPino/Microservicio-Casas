package com.pragma.microserviciocasas.domain.usecases;

import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.domain.exceptions.HomeAlreadyExistsException;
import com.pragma.microserviciocasas.domain.exceptions.InvalidPageOrSizeException;
import com.pragma.microserviciocasas.domain.models.CategoryModel;
import com.pragma.microserviciocasas.domain.models.CityModel;
import com.pragma.microserviciocasas.domain.models.HomeModel;
import com.pragma.microserviciocasas.domain.models.LocationModel;
import com.pragma.microserviciocasas.domain.ports.out.HomePersistencePort;
import com.pragma.microserviciocasas.domain.utils.PageResult;
import com.pragma.microserviciocasas.domain.utils.enumerations.PublicationStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HomeUseCaseTest {

    @Mock
    private HomePersistencePort homePersistencePort;

    @InjectMocks
    private HomeUseCase homeUseCase;

    private HomeModel homeModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        homeModel = new HomeModel(
                1L, "Home Name", "Description", 3, 2,
                BigDecimal.valueOf(100000), LocalDate.now(),
                LocalDate.now(), // Ajustamos publicationDateActive para que sea igual a publicationDate
                PublicationStatus.PUBLISHED,
                new CategoryModel(1L, "CategoryName", "CategoryDescription"),
                new LocationModel(1L, "LocationSector", new CityModel())
        );
    }

    @Test
    void shouldPublishHomeSuccessfully() {
        when(homePersistencePort.existsByNameAndLocationId(homeModel.getName(), homeModel.getLocation().getId()))
                .thenReturn(false);

        homeUseCase.publishHome(homeModel);

        assertEquals(PublicationStatus.PUBLISHED, homeModel.getStatus());
        verify(homePersistencePort, times(1)).publishHome(homeModel);
    }

    @Test
    void shouldThrowExceptionWhenHomeAlreadyExists() {
        when(homePersistencePort.existsByNameAndLocationId(homeModel.getName(), homeModel.getLocation().getId()))
                .thenReturn(true);

        assertThrows(HomeAlreadyExistsException.class, () -> homeUseCase.publishHome(homeModel));
        verify(homePersistencePort, never()).publishHome(any());
    }

    @Test
    void shouldSetStatusToPublicationPausedIfActiveDateNotReached() {
        homeModel.setPublicationDateActive(LocalDate.now().plusDays(2));

        when(homePersistencePort.existsByNameAndLocationId(homeModel.getName(), homeModel.getLocation().getId()))
                .thenReturn(false);

        homeUseCase.publishHome(homeModel);

        assertEquals(PublicationStatus.PUBLICATION_PAUSED, homeModel.getStatus());
        verify(homePersistencePort, times(1)).publishHome(homeModel);
    }

    @Test
    void shouldUpdateHomesStatusSuccessfully() {
        doNothing().when(homePersistencePort).updateStatusToPublishedIfActiveDateReached();

        homeUseCase.updateHomesStatus();

        verify(homePersistencePort, times(1)).updateStatusToPublishedIfActiveDateReached();
    }

    @Test
    void shouldThrowExceptionWhenTextIsNullOrEmpty() {
        assertThrows(EmptyFieldException.class, () -> homeUseCase.searchHomes(null, 0, 10, true));
        assertThrows(EmptyFieldException.class, () -> homeUseCase.searchHomes("", 0, 10, true));
    }

    @Test
    void shouldThrowExceptionWhenPageOrSizeIsInvalid() {
        assertThrows(InvalidPageOrSizeException.class, () -> homeUseCase.searchHomes("test", -1, 10, true));
        assertThrows(InvalidPageOrSizeException.class, () -> homeUseCase.searchHomes("test", 0, 0, true));
    }

    @Test
    void shouldReturnSearchResultsWhenParametersAreValid() {
        PageResult<HomeModel> expectedResult = new PageResult<>(
                Collections.singletonList(homeModel),
                0, 10, true, 1L, 1
        );

        when(homePersistencePort.searchHomes("test", 0, 10, true)).thenReturn(expectedResult);
        expectedResult.setContent(Collections.emptyList());
        expectedResult.setPage(0);
        expectedResult.setSize(10);
        expectedResult.setTotalElements(0);

        when(homePersistencePort.searchHomes("test", 0, 10, true)).thenReturn(expectedResult);

        PageResult<HomeModel> result = homeUseCase.searchHomes("test", 0, 10, true);

        assertNotNull(result);
        assertEquals(expectedResult, result);
        verify(homePersistencePort, times(1)).searchHomes("test", 0, 10, true);
    }
}