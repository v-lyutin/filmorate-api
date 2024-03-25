package com.filmorate.filmorateapi.media.content.web.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ContentTypeRequest(
        @NotBlank(message = "The 'name' field should not be an empty")
        String name) {
}
