package com.filmorate.filmorateapi.media.series.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public record EpisodeResponse(
        long episodeId,

        String previewUrl,

        String title,

        String originalTitle,

        int episodeNumber,

        String description,

        int duration,

        @JsonFormat(pattern = "yyyy-MM-dd")
        Date releaseDate) {
}
