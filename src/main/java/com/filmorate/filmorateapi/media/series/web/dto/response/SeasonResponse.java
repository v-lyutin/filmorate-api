package com.filmorate.filmorateapi.media.series.web.dto.response;
import java.util.List;

public record SeasonResponse(
        long seasonId,

        String posterUrl,

        int seasonNumber,

        int episodesCount,

        List<EpisodePreviewResponse> episodes) {
}
