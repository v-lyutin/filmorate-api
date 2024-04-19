package com.filmorate.filmorateapi.media.series.web.dto.request;

import jakarta.validation.constraints.Positive;
import org.openapitools.jackson.nullable.JsonNullable;

public record SeasonUpdateRequest(
        JsonNullable<String> posterUrl,

        @Positive(message = "The 'seasonNumber' field must be a positive number and not equal to zero")
        JsonNullable<Integer> seasonNumber) {
}
