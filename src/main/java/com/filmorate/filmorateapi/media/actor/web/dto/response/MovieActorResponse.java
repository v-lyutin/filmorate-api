package com.filmorate.filmorateapi.media.actor.web.dto.response;

import com.filmorate.filmorateapi.media.person.web.dto.response.PersonDemoResponse;

public record MovieActorResponse(
    long actorId,

    long movieId,

    PersonDemoResponse personPreview,

    String role,

    boolean isMainRole) {
}
