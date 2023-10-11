package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.softuni.mobilele.model.enums.EngineEnum;
import org.softuni.mobilele.model.enums.TransmissionEnum;

public record CreateOfferDTO(
        @NotEmpty(message = "Description must not be empty!")
        @Size(min = 5, max = 512, message = "Description size must be at least 5 symbols!")
        String description,

        @Positive
        @NotNull
        Long modelId,

        @NotNull
        EngineEnum engine,

        @NotNull
        TransmissionEnum transmission,

        @NotEmpty
        String imageUrl,

        @NotNull
        @Positive
        Integer mileage,

        @Positive
        @NotNull
        Integer price,

        @NotNull
        Integer year) {

    public CreateOfferDTO {
    }
}
