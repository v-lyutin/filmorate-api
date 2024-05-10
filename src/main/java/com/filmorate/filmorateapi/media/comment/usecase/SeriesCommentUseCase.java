package com.filmorate.filmorateapi.media.comment.usecase;

import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentPageRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentPageResponse;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentResponse;
import jakarta.validation.Valid;

public interface SeriesCommentUseCase {
    CommentResponse createComment(Long seriesId, CommentRequest request);

    CommentPageResponse getCommentsBySeries(Long seriesId, @Valid CommentPageRequest request);

    void removeAllCommentsBySeries(Long seriesId);
}
