package com.filmorate.filmorateapi.media.person.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record PersonFindRequest(
        @Min(0)
        int page,

        @Min(10)
        @Max(100)
        int limit) {
}
