package com.filmorate.filmorateapi.user.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;

public record UserProfileResponse(
        String imageLink,

        String nickname,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        Instant createdAt) {
}
