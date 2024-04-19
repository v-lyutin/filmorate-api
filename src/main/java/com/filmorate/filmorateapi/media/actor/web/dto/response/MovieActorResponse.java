package com.filmorate.filmorateapi.media.actor.web.dto.response;

import com.filmorate.filmorateapi.media.person.web.dto.response.PersonPreviewResponse;

public record MovieActorResponse(
    long actorId,

    long movieId,

    PersonPreviewResponse personPreview,

    String role,

    boolean isMainRole) {
}
