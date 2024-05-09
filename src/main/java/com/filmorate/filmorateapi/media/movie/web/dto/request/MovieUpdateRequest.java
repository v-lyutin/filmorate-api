package com.filmorate.filmorateapi.media.movie.web.dto.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Set;

public record MovieUpdateRequest(
        @Size(max = 100, message = "The size of the 'posterUrl' field must not exceed 100 characters")
        JsonNullable<String> posterUrl,

        @Size(max = 32, message = "The size of the 'title' field must not exceed 32 characters")
        JsonNullable<String> title,

        @Size(max = 32, message = "The size of the 'originalTitle' field must not exceed 32 characters")
        JsonNullable<String> originalTitle,

        @Size(max = 1000, message = "The size of the 'description' field must not exceed 1000 characters")
        JsonNullable<String> description,

        @Positive(message = "The 'releaseYear' field must be a positive number and not equal to zero")
        JsonNullable<Integer> releaseYear,

        @Size(max = 20, message = "The size of the 'country' field must not exceed 32 characters")
        JsonNullable<String> country,

        @Positive(message = "The 'duration' field must be a positive number and not equal to zero")
        JsonNullable<Integer> duration,

        JsonNullable<Set<String>> genres,

        @Size(max = 5, message = "The size of the 'mpaaRating' field must not exceed 5 characters")
        JsonNullable<String> mpaaRating,

        @Size(max = 5, message = "The size of the 'rarsRating' field must not exceed 5 characters")
        JsonNullable<String> rarsRating) {
}
