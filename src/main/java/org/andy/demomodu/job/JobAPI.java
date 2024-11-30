package org.andy.demomodu.job;

import lombok.extern.slf4j.Slf4j;
import org.andy.demomodu.OfferCreatedEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JobAPI {

    @ApplicationModuleListener
    public void onOfferCreated(OfferCreatedEvent event) {
        log.info("Received offer created event: {}", event);
    }
}
