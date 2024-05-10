package com.filmorate.filmorateapi.media.comment.usecase.impl;

import com.filmorate.filmorateapi.media.comment.exception.CommentServiceException;
import com.filmorate.filmorateapi.media.comment.mapper.CommentMapper;
import com.filmorate.filmorateapi.media.comment.model.Comment;
import com.filmorate.filmorateapi.media.comment.service.CommentService;
import com.filmorate.filmorateapi.media.comment.usecase.CommentCommonUseCase;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentResponse;
import com.filmorate.filmorateapi.user.api.CurrentUserProfileApiService;
import com.filmorate.filmorateapi.user.model.UserProfile;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CommentCommonUseCaseFacade implements CommentCommonUseCase {
    private final CommentService commentService;
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final CommentMapper commentMapper;

    @Override
    public CommentResponse updateComment(Long commentId, CommentRequest request) {
        Comment comment = commentService.getCommentById(commentId);
        UserProfile owner = currentUserProfileApiService.currentUserProfile();
        UserProfile actor = comment.getUserProfile();
        if (!Objects.equals(owner.getId(), actor.getId())) {
            throw new CommentServiceException(
                    HttpStatus.BAD_REQUEST,
                    "No rights to edit the comment");
        }
        comment.setText(request.text());
        return commentMapper.map(commentService.updateComment(comment));
    }

    @Override
    public void removeCommentById(Long commentId) {
        Comment comment = commentService.getCommentById(commentId);
        UserProfile owner = currentUserProfileApiService.currentUserProfile();
        UserProfile actor = comment.getUserProfile();
        if (!Objects.equals(owner.getId(), actor.getId())) {
            throw new CommentServiceException(
                    HttpStatus.BAD_REQUEST,
                    "No rights to edit the comment");
        }
        commentService.removeCommentById(commentId);
    }

    @Override
    public UserProfile getOwner() {
        return currentUserProfileApiService.currentUserProfile();
    }

    @Override
    public CommentResponse getCommentById(Long commentId) {
        return commentMapper.map(commentService.getCommentById(commentId));
    }

    @Override
    @Transactional
    public void toggleLike(Long commentId) {
        Comment comment = commentService.getCommentById(commentId);
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();
        commentService.toggleLike(comment, userProfile);
    }

    @Override
    @Transactional
    public void toggleDislike(Long commentId) {
        Comment comment = commentService.getCommentById(commentId);
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();
        commentService.toggleDislike(comment, userProfile);
    }
}
