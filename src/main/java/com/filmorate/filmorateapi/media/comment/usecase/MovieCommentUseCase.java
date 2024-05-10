package com.filmorate.filmorateapi.media.comment.usecase;

import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentPageRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentPageResponse;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface MovieCommentUseCase {
    CommentResponse createComment(Long movieId, CommentRequest request);

    CommentPageResponse getCommentsByMovie(Long movieId, @Valid CommentPageRequest request);

    void removeAllCommentsByMovie(Long movieId);
}
