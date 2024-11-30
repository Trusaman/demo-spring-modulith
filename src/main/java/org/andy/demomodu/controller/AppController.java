package org.andy.demomodu.controller;

import org.andy.demomodu.offer.OfferAPI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private final OfferAPI offerAPI;

    public AppController(OfferAPI offerAPI) {
        this.offerAPI = offerAPI;
    }

    @GetMapping("/{name}")
    public String offer(@PathVariable String name) {
        offerAPI.createOffer(name);
        return "Create offer";
    }

}
