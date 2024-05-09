package com.filmorate.filmorateapi.media.rating.web.dto.request;

import jakarta.validation.constraints.Size;
import org.openapitools.jackson.nullable.JsonNullable;

public record RatingUpdateRequest(
        @Size(max = 32, message = "The size of the 'name' field must not exceed 32 characters")
        JsonNullable<String> name,

        @Size(max = 1000, message = "The size of the 'description' field must not exceed 32 characters")
        JsonNullable<String> description) {
}
