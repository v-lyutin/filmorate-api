package com.filmorate.filmorateapi.media.comment.usecase;

import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentPageRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentPageResponse;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentResponse;
import jakarta.validation.Valid;

public interface EpisodeCommentUseCase {
    CommentResponse createComment(Long episodeId, CommentRequest request);

    CommentResponse updateComment(Long commentId, CommentRequest request);

    CommentPageResponse getCommentsByEpisode(Long episodeId, @Valid CommentPageRequest request);

    CommentResponse getCommentById(Long commentId);

    void removeCommentById(Long commentId);

    void removeAllCommentsByEpisode(Long episodeId);
}
