package com.filmorate.filmorateapi.media.rating.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RatingCreationRequest(
        @NotBlank(message = "The 'name' should not be an empty")
        @Size(max = 32, message = "The size of the 'name' field must not exceed 32 characters")
        String name,

        @NotBlank(message = "The 'description' should not be an empty")
        @Size(max = 1000, message = "The size of the 'description' field must not exceed 32 characters")
        String description) {
}
