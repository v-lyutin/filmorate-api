package com.filmorate.filmorateapi.user.web.dto;

import com.filmorate.filmorateapi.user.validation.Nickname;
import org.openapitools.jackson.nullable.JsonNullable;

public record UserProfileUpdateRequest(
        JsonNullable<String> imageLink,

        @Nickname
        JsonNullable<String> nickname) {
}
