package com.filmorate.filmorateapi.media.movie.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;

public record MovieCreationResponse(
        Long id,

        String url,

        String posterUrl,

        String name,

        String enName,

        String description,

        String enDescription,

        Integer releaseYear,

        Integer duration,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        Instant createdAt) {
}
