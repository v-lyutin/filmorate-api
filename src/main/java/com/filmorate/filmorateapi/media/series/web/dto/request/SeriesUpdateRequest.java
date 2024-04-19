package com.filmorate.filmorateapi.media.series.web.dto.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Set;

public record SeriesUpdateRequest(
        JsonNullable<String> posterUrl,

        @Size(max = 32, message = "The size of the 'title' field must not exceed 32 characters")
        JsonNullable<String> title,

        @Size(max = 32, message = "The size of the 'originalTitle' field must not exceed 32 characters")
        JsonNullable<String> originalTitle,

        JsonNullable<Set<String>> genres,

        @Size(max = 1000, message = "The size of the 'description' field must not exceed 32 characters")
        JsonNullable<String> description,

        @Positive(message = "The 'releaseYear' field must be a positive number and not equal to zero")
        JsonNullable<Integer> releaseYear,

        @Size(max = 32, message = "The size of the 'title' field must not exceed 32 characters")
        JsonNullable<String> country,

        JsonNullable<Boolean> isFinished) {
}
