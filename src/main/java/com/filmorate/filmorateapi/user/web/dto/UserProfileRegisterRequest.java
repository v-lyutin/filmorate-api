package com.filmorate.filmorateapi.user.web.dto;

import com.filmorate.filmorateapi.user.validation.Nickname;

public record UserProfileRegisterRequest(
        @Nickname
        String nickname,
        String imageLink) {
}
