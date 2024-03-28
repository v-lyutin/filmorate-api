package com.filmorate.filmorateapi.media.movie.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.Set;

public record MovieCreationRequest(
        @NotBlank(message = "The 'title' field should not be an empty")
        String title,

        @NotBlank(message = "The 'enTitle' field should not be an empty")
        String enTitle,

        @NotBlank(message = "The 'description' field should not be an empty")
        String description,

        @NotNull(message = "The 'releaseYear' field should not be an empty")
        @Positive(message = "The 'releaseYear' field must be a positive number and not equal to zero")
        Integer releaseYear,

        @NotBlank(message = "The 'country' field should not be an empty")
        String country,

        @NotEmpty(message = "The 'genres' field should not be an empty")
        Set<String> genres,

        @NotNull(message = "The 'duration' field should not be an empty")
        @Positive(message = "The 'duration' field must be a positive number and not equal to zero")
        Integer duration) {
}
