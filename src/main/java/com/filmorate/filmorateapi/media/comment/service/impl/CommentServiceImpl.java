package com.filmorate.filmorateapi.media.comment.service.impl;

import com.filmorate.filmorateapi.media.comment.exception.CommentServiceException;
import com.filmorate.filmorateapi.media.comment.model.Comment;
import com.filmorate.filmorateapi.media.comment.repository.CommentRepository;
import com.filmorate.filmorateapi.media.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Comment with ID = %d not found", commentId)
                ));
    }

    @Override
    public void removeCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
