package com.filmorate.filmorateapi.media.fact.web.dto;

import java.time.Instant;

public record FactResponse(
        long id,
        String text,
        Instant createdAt,

        String createdBy) {
}
