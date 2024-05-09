package com.filmorate.filmorateapi.media.movie.web.dto.request;

import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Set;

public record MovieFindRequest(
        JsonNullable<String> title,

        JsonNullable<String> originalTitle,

        JsonNullable<Integer> releaseYear,

        JsonNullable<String> country,

        JsonNullable<Integer> duration,

        JsonNullable<String> mpaaRating,

        JsonNullable<String> rarsRating,

        JsonNullable<Set<String>> genres) {
}
