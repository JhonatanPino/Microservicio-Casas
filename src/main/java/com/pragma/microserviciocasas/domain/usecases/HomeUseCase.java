package com.pragma.microserviciocasas.domain.usecases;

import com.pragma.microserviciocasas.domain.exceptions.HomeAlreadyExistsException;
import com.pragma.microserviciocasas.domain.models.HomeModel;
import com.pragma.microserviciocasas.domain.ports.in.HomeServicePort;
import com.pragma.microserviciocasas.domain.ports.out.HomePersistencePort;
import com.pragma.microserviciocasas.domain.utils.enumerations.PublicationStatus;

public class HomeUseCase implements HomeServicePort {
    private final HomePersistencePort homePersistencePort;

    public HomeUseCase(HomePersistencePort homePersistencePort) {
        this.homePersistencePort = homePersistencePort;
    }

    @Override
    public void publishHome(HomeModel homeModel) {
        boolean home = homePersistencePort.existsByNameAndLocationId(homeModel.getName(), homeModel.getLocation().getId());

        if (home) {
            throw new HomeAlreadyExistsException();
        }

        if (homeModel.getPublicationDateActive() != null &&
                homeModel.getPublicationDateActive().isEqual(java.time.LocalDate.now())) {
            homeModel.setStatus(PublicationStatus.PUBLISHED);
        } else {
            homeModel.setStatus(PublicationStatus.PUBLICATION_PAUSED);
        }

        homePersistencePort.publishHome(homeModel);
    }
}
