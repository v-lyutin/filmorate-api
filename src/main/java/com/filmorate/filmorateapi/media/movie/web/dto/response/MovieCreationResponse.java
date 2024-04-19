package com.filmorate.filmorateapi.media.movie.web.dto.response;

import java.util.List;

public record MovieCreationResponse(
        Long id,

        String posterUrl,

        String title,

        String originalTitle,

        String description,

        Integer releaseYear,

        String country,

        List<String> genres,

        Integer duration) {
}
