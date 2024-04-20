package com.filmorate.filmorateapi.media.actor.web.dto.response;

import java.util.List;

public record SeriesActorPageResponse(
        long totalPages,

        boolean isFirstPage,

        boolean isLastPage,

        long totalActors,

        List<SeriesActorResponse> persons) {
}
