package com.filmorate.filmorateapi.user.web.dto.response;

public record UserProfileResponse(
        long id,

        String imageLink,

        String nickname) {
}
