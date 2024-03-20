package com.filmorate.filmorateapi.media.movie.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Set;

public record MovieCreationRequest(
        @NotBlank(message = "The 'posterUrl' field should not be an empty")
        String posterUrl,

        @NotBlank(message = "The 'title' field should not be an empty")
        String title,

        @NotBlank(message = "The 'enTitle' field should not be an empty")
        String enTitle,

        @NotBlank(message = "The 'description' field should not be an empty")
        String description,

        @NotBlank(message = "The 'enDescription' field description should not be an empty")
        String enDescription,

        @NotNull(message = "The 'releaseYear' field should not be an empty")
        @Positive(message = "The 'releaseYear' field must be a positive number and not equal to zero")
        Integer releaseYear,

        @NotBlank(message = "The 'country' field should not be an empty")
        String country,

        JsonNullable<Set<String>> genres,

        JsonNullable<String> director,

        @NotNull(message = "The 'duration' field should not be an empty")
        @Positive(message = "The 'duration' field must be a positive number and not equal to zero")
        Integer duration) {
}
