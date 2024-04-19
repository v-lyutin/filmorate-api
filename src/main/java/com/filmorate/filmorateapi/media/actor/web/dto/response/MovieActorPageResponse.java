package com.filmorate.filmorateapi.media.actor.web.dto.response;

import java.util.List;

public record MovieActorPageResponse(
        long totalPages,

        boolean isFirstPage,

        boolean isLastPage,

        long totalActors,

        List<MovieActorResponse> persons) {
}
