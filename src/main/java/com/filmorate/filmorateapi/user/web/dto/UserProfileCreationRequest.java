package com.filmorate.filmorateapi.user.web.dto;

import com.filmorate.filmorateapi.user.validation.Nickname;

public record UserProfileCreationRequest(
        @Nickname
        String nickname,

        String imageLink) {
}
