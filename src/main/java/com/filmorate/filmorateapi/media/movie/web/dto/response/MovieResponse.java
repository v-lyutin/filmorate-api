package com.filmorate.filmorateapi.media.movie.web.dto.response;

import java.util.List;

public record MovieResponse(
        long id,

        String posterUrl,

        String title,

        String originalTitle,

        String description,

        Integer releaseYear,

        String country,

        List<String> genres,

        Integer duration,

        long likesCount) {
}
