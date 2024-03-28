package com.filmorate.filmorateapi.media.movie.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;
import java.util.List;

public record MovieCreationResponse(
        Long id,

        String title,

        String enTitle,

        String description,

        Integer releaseYear,

        String country,

        List<String> genres,

        Integer duration,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        Instant createdAt) {
}
