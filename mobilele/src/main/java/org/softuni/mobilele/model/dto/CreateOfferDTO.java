package org.softuni.mobilele.model.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.softuni.mobilele.model.enums.EngineEnum;
import org.softuni.mobilele.model.enums.TransmissionEnum;

import java.math.BigDecimal;

public record CreateOfferDTO(
         String description,
         Long modelId,
         EngineEnum engine,
         TransmissionEnum transmission,
         String imageUrl,
         BigDecimal price,
         Integer year
) {
}
