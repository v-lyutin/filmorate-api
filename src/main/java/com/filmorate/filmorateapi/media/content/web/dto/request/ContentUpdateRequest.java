package com.filmorate.filmorateapi.media.content.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.openapitools.jackson.nullable.JsonNullable;

public record ContentUpdateRequest(
        JsonNullable<String> title,

        @NotBlank(message = "The 'url' field should not be an empty")
        String url) {
}
