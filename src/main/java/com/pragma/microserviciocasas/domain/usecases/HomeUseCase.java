package com.pragma.microserviciocasas.domain.usecases;

import com.pragma.microserviciocasas.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciocasas.domain.exceptions.HomeAlreadyExistsException;
import com.pragma.microserviciocasas.domain.exceptions.InvalidPageOrSizeException;
import com.pragma.microserviciocasas.domain.models.HomeModel;
import com.pragma.microserviciocasas.domain.ports.in.HomeServicePort;
import com.pragma.microserviciocasas.domain.ports.out.HomePersistencePort;
import com.pragma.microserviciocasas.domain.utils.PageResult;
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

        if (homeModel.getPublicationDateActive() != null && homeModel.getPublicationDateActive().isEqual(homeModel.getPublicationDate())) {
            homeModel.setStatus(PublicationStatus.PUBLISHED);
        } else {
            homeModel.setStatus(PublicationStatus.PUBLICATION_PAUSED);
        }

        homePersistencePort.publishHome(homeModel);
    }

    public void updateHomesStatus() {
        homePersistencePort.updateStatusToPublishedIfActiveDateReached();
    }

    @Override
    public PageResult<HomeModel> searchHomes(String text, Integer page, Integer size, boolean orderAsc) {
        if (text == null || text.isBlank()) {
            throw new EmptyFieldException();
        }
        if (page < 0 || size <= 0) {
            throw new InvalidPageOrSizeException();
        }

        return homePersistencePort.searchHomes(text, page, size, orderAsc);
    }
}
