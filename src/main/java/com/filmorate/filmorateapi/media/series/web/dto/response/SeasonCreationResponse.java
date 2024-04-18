package com.filmorate.filmorateapi.media.series.web.dto.response;

public record SeasonCreationResponse(
        long seasonId,

        String posterUrl,

        int seasonNumber) {
}
