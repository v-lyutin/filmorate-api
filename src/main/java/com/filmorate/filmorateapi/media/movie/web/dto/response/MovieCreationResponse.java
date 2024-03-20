package com.filmorate.filmorateapi.media.movie.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonDemoResponse;
import java.time.Instant;
import java.util.List;

public record MovieCreationResponse(
        Long id,

        String title,

        String enTitle,

        String description,

        String enDescription,

        Integer releaseYear,

        String country,

        List<String> genres,

        PersonDemoResponse director,

        Integer duration,

        String posterUrl,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        Instant createdAt) {
}
