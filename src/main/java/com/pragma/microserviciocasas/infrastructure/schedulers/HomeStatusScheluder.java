package com.pragma.microserviciocasas.infrastructure.schedulers;

import com.pragma.microserviciocasas.domain.usecases.HomeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HomeStatusScheluder {
    private final HomeUseCase homeUseCase;

    @EventListener(ContextRefreshedEvent.class)
    public void updateHomeStatusesOnStartup() {
        homeUseCase.updateHomesStatus();
    }

}
 /*@Scheduled(cron = "0 0 0 * * ?")
    public void updateHomeStatuses() {
        homeUseCase.updateHomesStatus();
    }*/