package com.filmorate.filmorateapi.media.movie.web.dto.request;

import jakarta.validation.constraints.*;

import java.util.Set;

public record MovieCreationRequest(
        @NotBlank(message = "The 'title' field should not be an empty")
        String posterUrl,

        @NotBlank(message = "The 'title' field should not be an empty")
        String title,

        @NotBlank(message = "The 'originalTitle' field should not be an empty")
        String originalTitle,

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
        Integer duration,

        @NotBlank(message = "The 'mpaaRating' should not be an empty")
        @Size(max = 5, message = "The size of the 'mpaaRating' field must not exceed 5 characters")
        String mpaaRating,

        @NotBlank(message = "The 'rarsRating' should not be an empty")
        @Size(max = 5, message = "The size of the 'rarsRating' field must not exceed 5 characters")
        String rarsRating) {
}
