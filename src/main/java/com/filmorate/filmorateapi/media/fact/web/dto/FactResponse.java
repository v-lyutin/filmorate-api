package com.filmorate.filmorateapi.media.fact.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.filmorate.filmorateapi.media.fact.model.FactType;
import java.time.Instant;

public record FactResponse(
        long id,

        FactType factType,

        long entityId,

        String text,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        Instant createdAt,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        Instant editedAt) {
}
