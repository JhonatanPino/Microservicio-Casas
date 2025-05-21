package com.pragma.microserviciocasas.infrastructure.adapters.persistence;

import com.pragma.microserviciocasas.commons.configurations.utils.Constants;
import com.pragma.microserviciocasas.domain.models.HomeModel;
import com.pragma.microserviciocasas.domain.ports.out.HomePersistencePort;
import com.pragma.microserviciocasas.domain.utils.PageResult;
import com.pragma.microserviciocasas.infrastructure.entities.HomeEntity;
import com.pragma.microserviciocasas.infrastructure.mappers.HomeEntityMapper;
import com.pragma.microserviciocasas.infrastructure.repositories.mysql.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HomePersistenceAdapter implements HomePersistencePort {
    public final HomeRepository homeRepository;
    public final HomeEntityMapper homeEntityMapper;

    @Override
    public void publishHome(HomeModel homeModel) {
        homeRepository.save(homeEntityMapper.modelToEntity(homeModel));
    }

    @Override
    public boolean existsByNameAndLocationId(String name, Long idLocation) {
        return homeRepository.existsByNameAndLocationId(name, idLocation);
    }

    @Override
    public void updateStatusToPublishedIfActiveDateReached() {
        homeRepository.updateStatusToPublishedIfActiveDateReached(LocalDate.now());
    }

    @Override
    public PageResult<HomeModel> searchHomes(String text, Integer page, Integer size, boolean orderAsc) {
        Pageable pagination;

        if (orderAsc){
            pagination = PageRequest.of(page, size, Sort.by( "category.name",
                            "location.sector",
                            "rooms",
                            "bathrooms",
                            "price")
                    .ascending());
        }
        else{
            pagination = PageRequest.of(page, size, Sort.by("category.name",
                            "location.sector",
                            "rooms",
                            "bathrooms",
                            "price")
                    .descending());
        }
        Page<HomeEntity> homes = homeRepository.findBySectorOrCategoryOrRoomsOrBathroomsOrPrice(text, pagination);
        List<HomeModel> homeModels = homeEntityMapper.entityListToModelList(homes.getContent());

        return new PageResult<>(
                homeModels,
                homes.getNumber(),
                homes.getSize(),
                orderAsc,
                homes.getTotalElements(),
                homes.getTotalPages()
        );

    }

}
