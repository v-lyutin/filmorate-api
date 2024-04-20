package com.filmorate.filmorateapi.media.actor.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ActorCreationRequest(
        @NotNull(message = "The 'personId' field should not be an empty")
        Long personId,

        @NotBlank(message = "The 'role' field should not be an empty")
        @Size(max = 32, message = "The size of the 'role' field must not exceed 32 characters")
        String role,

        @NotNull(message = "The 'isMainRole' field should not be an empty")
        boolean isMainRole) {
}
