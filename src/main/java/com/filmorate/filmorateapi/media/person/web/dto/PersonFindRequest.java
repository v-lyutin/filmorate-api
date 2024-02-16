package com.filmorate.filmorateapi.media.person.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record PersonFindRequest(
        @Min(value = 0, message = "Page must be positive")
        int page,

        @Min(value = 10, message = "The minimum limit is 10")
        @Max(value = 25, message = "The maximum limit is 25")
        int limit) {
}
