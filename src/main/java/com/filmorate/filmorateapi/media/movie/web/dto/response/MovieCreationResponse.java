package com.filmorate.filmorateapi.media.movie.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.genre.web.dto.GenreResponse;

import java.time.Instant;
import java.util.Set;

public record MovieCreationResponse(
        Long id,

        String title,

        String enTitle,

        String description,

        String enDescription,

        Integer releaseYear,

        String country,

        Set<GenreResponse> genres,

        Integer duration,

        String posterUrl,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        Instant createdAt) {
}
