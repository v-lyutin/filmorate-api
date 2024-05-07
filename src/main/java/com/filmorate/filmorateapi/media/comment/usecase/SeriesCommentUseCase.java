package com.filmorate.filmorateapi.media.comment.usecase;

import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentPageRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentPageResponse;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentResponse;
import jakarta.validation.Valid;

public interface SeriesCommentUseCase {
    CommentResponse createComment(Long seriesId, CommentRequest request);

    CommentResponse updateComment(Long commentId, CommentRequest request);

    CommentPageResponse getCommentsBySeries(Long seriesId, @Valid CommentPageRequest request);

    CommentResponse getCommentById(Long commentId);

    void removeCommentById(Long commentId);

    void removeAllCommentsBySeries(Long seriesId);
}
