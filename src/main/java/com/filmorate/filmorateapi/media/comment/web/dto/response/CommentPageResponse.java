package com.filmorate.filmorateapi.media.comment.web.dto.response;

import java.util.Collection;

public record CommentPageResponse(
        long totalPages,
        boolean isFirstPage,
        boolean isLastPage,
        long totalPersons,
        Collection<CommentResponse> comments) {
}
