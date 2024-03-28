package com.filmorate.filmorateapi.media.actor.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MovieActorCreationRequest(
        @NotNull(message = "The 'personId' field should not be an empty")
        Long personId,

        @NotBlank(message = "The 'role' field should not be an empty")
        String role,

        @NotNull(message = "The 'isMainRole' field should not be an empty")
        boolean isMainRole) {
}
