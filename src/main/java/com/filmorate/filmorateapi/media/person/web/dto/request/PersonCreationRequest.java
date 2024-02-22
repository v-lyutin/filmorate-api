package com.filmorate.filmorateapi.media.person.web.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import java.util.Date;

public record PersonCreationRequest(
        @NotBlank(message = "The image link must be not empty")
        String imageLink,

        @NotBlank(message = "The first name should not be an empty")
        String firstName,

        @NotBlank(message = "The first name should not be an empty")
        String lastName,

        @NotNull
        @PastOrPresent(message = "Date of birth from the future")
        @JsonFormat(pattern = "yyyy-MM-dd")
        Date birthDate,

        @NotBlank(message = "The country of birth should not be empty")
        String countryOfBirth,

        @NotBlank(message = "The city of birth should not be empty")
        String cityOfBirth,

        @Positive(message = "The height must be a positive number and not equal to zero")
        Integer height) {
}
