package com.filmorate.filmorateapi.media.comment.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.filmorate.filmorateapi.user.web.dto.response.UserProfilePreviewResponse;

import java.time.Instant;

public record CommentResponse(
        long commentId,

        UserProfilePreviewResponse author,

        String commentText,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        Instant createdAt,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        Instant editedAt,

        long likes,

        long dislikes) {
}
