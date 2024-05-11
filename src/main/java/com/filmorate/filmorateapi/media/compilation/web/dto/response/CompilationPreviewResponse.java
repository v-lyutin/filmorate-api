package com.filmorate.filmorateapi.media.compilation.web.dto.response;

import com.filmorate.filmorateapi.user.web.dto.response.UserProfilePreviewResponse;

import java.util.Set;

public record CompilationPreviewResponse(
        long compilationId,

        UserProfilePreviewResponse author,

        Set<String> genres,

        String title,

        long likesCount) {
}
