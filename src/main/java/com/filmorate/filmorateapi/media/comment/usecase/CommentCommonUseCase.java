package com.filmorate.filmorateapi.media.comment.usecase;

import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentResponse;
import com.filmorate.filmorateapi.user.model.UserProfile;

public interface CommentCommonUseCase {
    CommentResponse updateComment(Long commentId, CommentRequest request);

    void removeCommentById(Long commentId);

    UserProfile getOwner();

    CommentResponse getCommentById(Long commentId);

    void toggleLike(Long commentId);

    void toggleDislike(Long commentId);
}
