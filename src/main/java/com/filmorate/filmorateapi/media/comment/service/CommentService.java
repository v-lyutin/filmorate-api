package com.filmorate.filmorateapi.media.comment.service;

import com.filmorate.filmorateapi.media.comment.model.Comment;

public interface CommentService {
    Comment createComment(Comment comment);

    Comment updateComment(Comment comment);

    Comment getCommentById(Long commentId);

    void removeCommentById(Long commentId);
}
