package com.pragma.microserviciocasas.infrastructure.adapters.persistence;

import com.pragma.microserviciocasas.domain.models.HomeModel;
import com.pragma.microserviciocasas.domain.ports.out.HomePersistencePort;
import com.pragma.microserviciocasas.infrastructure.mappers.HomeEntityMapper;
import com.pragma.microserviciocasas.infrastructure.repositories.mysql.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
