package com.filmorate.filmorateapi.media.person.web.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import java.util.Date;

public record PersonCreationRequest(
        @NotBlank(message = "The 'imageLink' field must be not empty")
        String imageLink,

        @NotBlank(message = "The 'name' should not be an empty")
        String name,

        @NotNull
        @PastOrPresent(message = "The 'birthDate' from the future")
        @JsonFormat(pattern = "yyyy-MM-dd")
        Date birthDate,

        @NotBlank(message = "The 'countryOfBirth' field should not be empty")
        String countryOfBirth,

        @NotBlank(message = "The 'cityOfBirth' field should not be empty")
        String cityOfBirth,

        @Positive(message = "The 'height' field must be a positive number and not equal to zero")
        Integer height) {
}
