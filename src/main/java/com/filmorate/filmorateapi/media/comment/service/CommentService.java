package com.filmorate.filmorateapi.media.comment.service;

import com.filmorate.filmorateapi.media.comment.model.Comment;
import com.filmorate.filmorateapi.user.model.UserProfile;

public interface CommentService {
    Comment createComment(Comment comment);

    Comment updateComment(Comment comment);

    Comment getCommentById(Long commentId);

    void removeCommentById(Long commentId);

    void toggleLike(Comment comment, UserProfile userProfile);

    void toggleDislike(Comment comment, UserProfile userProfile);

    Long getCommentLikeCount(Long commentId);

    Long getCommentDislikeCount(Long commentId);
}
