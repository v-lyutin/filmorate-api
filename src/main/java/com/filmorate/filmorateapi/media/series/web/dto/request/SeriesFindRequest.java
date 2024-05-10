package com.filmorate.filmorateapi.media.series.web.dto.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Set;

public record SeriesFindRequest(
        @Size(max = 32, message = "The size of the 'title' field must not exceed 32 characters")
        JsonNullable<String> title,

        @Size(max = 32, message = "The size of the 'originalTitle' field must not exceed 32 characters")
        JsonNullable<String> originalTitle,

        @Size(max = 32, message = "The size of the 'releaseYear' field must not exceed 32 characters")
        JsonNullable<Integer> releaseYear,

        @Size(max = 20, message = "The size of the 'country' field must not exceed 32 characters")
        JsonNullable<String> country,

        @Positive(message = "The 'duration' field must be a positive number and not equal to zero")
        JsonNullable<Integer> duration,

        JsonNullable<Boolean> isFinished,

        @Size(max = 5, message = "The size of the 'mpaaRating' field must not exceed 5 characters")
        JsonNullable<String> mpaaRating,

        @Size(max = 5, message = "The size of the 'rarsRating' field must not exceed 5 characters")
        JsonNullable<String> rarsRating,

        JsonNullable<Set<String>> genres) {
}
