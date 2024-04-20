package com.filmorate.filmorateapi.media.actor.web.dto.request;

import jakarta.validation.constraints.Size;
import org.openapitools.jackson.nullable.JsonNullable;

public record ActorUpdateRequest(
        @Size(max = 32, message = "The size of the 'role' field must not exceed 32 characters")
        JsonNullable<String> role,

        JsonNullable<Boolean> isMainRole) {
}
