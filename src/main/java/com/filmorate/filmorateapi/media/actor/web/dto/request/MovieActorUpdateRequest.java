package com.filmorate.filmorateapi.media.actor.web.dto.request;

import org.openapitools.jackson.nullable.JsonNullable;

public record MovieActorUpdateRequest(
        JsonNullable<String> role,

        JsonNullable<Boolean> isMainRole) {
}
