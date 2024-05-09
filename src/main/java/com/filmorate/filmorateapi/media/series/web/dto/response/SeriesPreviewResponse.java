package com.filmorate.filmorateapi.media.series.web.dto.response;

import java.util.List;

public record SeriesPreviewResponse(
        long id,

        String posterUrl,

        String title,

        String originalTitle,

        List<String> genres,

        String mpaaRating,

        String rarsRaring,

        long likesCount) {
}
