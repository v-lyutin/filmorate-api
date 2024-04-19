package com.filmorate.filmorateapi.media.series.web.dto.response;

public record EpisodePreviewResponse(
        long episodeId,

        String previewUrl,

        String title,

        String enTitle,

        int season,

        int episodeNumber) {
}
