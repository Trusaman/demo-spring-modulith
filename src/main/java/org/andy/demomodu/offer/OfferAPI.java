package org.andy.demomodu.offer;

import org.andy.demomodu.OfferCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OfferAPI {


    private final ApplicationEventPublisher applicationEventPublisher;
    private final OfferRepository offerRepository;

    public OfferAPI(ApplicationEventPublisher applicationEventPublisher, OfferRepository offerRepository) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.offerRepository = offerRepository;
    }

    @Transactional
    public void createOffer(String offerName) {
        System.out.println("Offer created");
        Offer save = offerRepository.save(Offer.builder().name(offerName).build());
        applicationEventPublisher.publishEvent(new OfferCreatedEvent(save.getId().toString(), save.getName()));
    }
}
