package com.filmorate.filmorateapi.media.series.web.dto.request;

import jakarta.validation.constraints.*;

import java.util.Set;

public record SeriesCreationRequest(
        @NotBlank(message = "The 'title' field should not be an empty")
        String posterUrl,

        @NotBlank(message = "The 'title' field should not be an empty")
        @Size(max = 32, message = "The size of the 'title' field must not exceed 32 characters")
        String title,

        @NotBlank(message = "The 'originalTitle' field should not be an empty")
        @Size(max = 32, message = "The size of the 'originalTitle' field must not exceed 32 characters")
        String originalTitle,

        @NotEmpty(message = "The 'genres' field should not be an empty")
        Set<String> genres,

        @NotBlank(message = "The 'description' field should not be an empty")
        @Size(max = 1000, message = "The size of the 'description' field must not exceed 32 characters")
        String description,

        @NotNull(message = "The 'releaseYear' field should not be an empty")
        @Positive(message = "The 'releaseYear' field must be a positive number and not equal to zero")
        Integer releaseYear,

        @NotBlank(message = "The 'country' field should not be an empty")
        @Size(max = 32, message = "The size of the 'title' field must not exceed 32 characters")
        String country,

        @NotNull(message = "The 'isFinished' field should not be an empty")
        Boolean isFinished,

        @NotBlank(message = "The 'mpaaRating' should not be an empty")
        @Size(max = 5, message = "The size of the 'mpaaRating' field must not exceed 5 characters")
        String mpaaRating,

        @NotBlank(message = "The 'rarsRating' should not be an empty")
        @Size(max = 5, message = "The size of the 'rarsRating' field must not exceed 5 characters")
        String rarsRating) {
}
