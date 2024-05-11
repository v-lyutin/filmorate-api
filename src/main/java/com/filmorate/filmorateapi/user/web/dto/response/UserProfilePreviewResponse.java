package com.filmorate.filmorateapi.user.web.dto.response;

public record UserProfilePreviewResponse(
        long userProfileId,

        String avatarUrl,

        String nickname) {
}
