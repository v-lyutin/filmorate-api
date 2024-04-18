package com.filmorate.filmorateapi.media.series.web.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Date;

public record EpisodeUpdateRequest(
        JsonNullable<String> previewUrl,

        @Size(max = 32, message = "The size of the 'title' field must not exceed 32 characters")
        JsonNullable<String> title,

        @Size(max = 32, message = "The size of the 'originalTitle' field must not exceed 32 characters")
        JsonNullable<String> originalTitle,

        @Size(max = 1000, message = "The size of the 'description' field must not exceed 32 characters")
        JsonNullable<String> description,

        @Positive(message = "The 'episodeNumber' field must be a positive number and not equal to zero")
        JsonNullable<Integer> episodeNumber,

        @Positive(message = "The 'episodeNumber' field must be a positive number and not equal to zero")
        JsonNullable<Integer> duration,

        @JsonFormat(pattern = "yyyy-MM-dd")
        JsonNullable<Date> releaseDate) {
}
