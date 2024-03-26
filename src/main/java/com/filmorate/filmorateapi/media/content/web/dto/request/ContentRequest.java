package com.filmorate.filmorateapi.media.content.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.openapitools.jackson.nullable.JsonNullable;

public record ContentRequest(
        JsonNullable<String> title,

        @NotBlank(message = "The 'url' field should not be an empty")
        String url) {
}
