package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.AddOfferDto;

import java.util.UUID;

public interface OfferService {

    UUID createOffer(AddOfferDto addOfferDto);
}
