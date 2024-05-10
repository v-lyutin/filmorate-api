package com.filmorate.filmorateapi.media.comment.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public record CommentResponse(
        long commentId,

        long authorId,

        String authorAvatarUrl,

        String authorNickname,

        String commentText,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        Instant createdAt,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        Instant editedAt,

        long likes,

        long dislikes) {
}
