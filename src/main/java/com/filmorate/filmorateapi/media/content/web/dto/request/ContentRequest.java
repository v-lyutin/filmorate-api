package com.filmorate.filmorateapi.media.content.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.openapitools.jackson.nullable.JsonNullable;

public record ContentRequest(
        @NotBlank(message = "The 'contentType' field should not be an empty")
        String contentType,

        JsonNullable<String> title,

        @NotBlank(message = "The 'url' field should not be an empty")
        String url) {
}
