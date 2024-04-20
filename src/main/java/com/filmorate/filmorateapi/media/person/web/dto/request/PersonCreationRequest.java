package com.filmorate.filmorateapi.media.person.web.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import java.util.Date;
import java.util.Set;

public record PersonCreationRequest(
        @NotBlank(message = "The 'imageLink' field must be not empty")
        String imageLink,

        @NotBlank(message = "The 'name' should not be an empty")
        @Size(max = 32, message = "The size of the 'name' field must not exceed 32 characters")
        String name,

        @NotBlank(message = "The 'name' should not be an empty")
        @Size(max = 32, message = "The size of the 'enName' field must not exceed 32 characters")
        String enName,

        @NotNull
        @PastOrPresent(message = "The 'birthDate' from the future")
        @JsonFormat(pattern = "yyyy-MM-dd")
        Date birthDate,

        @NotBlank(message = "The 'countryOfBirth' field should not be empty")
        @Size(max = 32, message = "The size of the 'countryOfBirth' field must not exceed 32 characters")
        String countryOfBirth,

        @NotBlank(message = "The 'cityOfBirth' field should not be empty")
        @Size(max = 32, message = "The size of the 'cityOfBirth' field must not exceed 32 characters")
        String cityOfBirth,

        @NotNull(message = "The 'height' field should not be an empty")
        @Positive(message = "The 'height' field must be a positive number and not equal to zero")
        Integer height,

        @NotEmpty(message = "The 'careers' field should not be empty")
        Set<String> careers) {
}
