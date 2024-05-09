package com.filmorate.filmorateapi.media.series.web.dto.response;

import com.filmorate.filmorateapi.media.rating.web.dto.response.RatingResponse;

import java.util.List;

public record SeriesResponse(
        long id,

        String posterUrl,

        String title,

        String originalTitle,

        List<String> genres,

        String description,

        Integer releaseYear,

        String country,

        Integer seasonsCount,

        Boolean isFinished,

        RatingResponse mpaaRating,

        RatingResponse rarsRaring,

        long likesCount) {
}
