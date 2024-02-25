package com.filmorate.filmorateapi.media.fact.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public record FactResponse(
        long id,

        String text,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        Instant createdAt,

        String createdBy,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        Instant editedAt,

        String editedBy) {
}
