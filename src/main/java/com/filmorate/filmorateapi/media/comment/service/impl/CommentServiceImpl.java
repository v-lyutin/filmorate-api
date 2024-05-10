package com.filmorate.filmorateapi.media.comment.service.impl;

import com.filmorate.filmorateapi.media.comment.exception.CommentServiceException;
import com.filmorate.filmorateapi.media.comment.model.Comment;
import com.filmorate.filmorateapi.media.comment.repository.CommentRepository;
import com.filmorate.filmorateapi.media.comment.service.CommentService;
import com.filmorate.filmorateapi.user.api.CurrentUserProfileApiService;
import com.filmorate.filmorateapi.user.model.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CurrentUserProfileApiService currentUserProfileApiService;

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

    @Override
    public void toggleLike(Comment comment, UserProfile userProfile) {
        Set<UserProfile> likedByUsers = comment.getLikedByUsers();
        Set<UserProfile> dislikedByUsers = comment.getDislikedByUsers();
        if (!likedByUsers.contains(userProfile)) {
            if (dislikedByUsers.contains(userProfile)) {
                likedByUsers.add(userProfile);
                dislikedByUsers.remove(userProfile);
            } else {
                likedByUsers.add(userProfile);
            }
        } else {
            likedByUsers.remove(userProfile);
        }
        commentRepository.save(comment);
    }

    @Override
    public void toggleDislike(Comment comment, UserProfile userProfile) {
        Set<UserProfile> dislikedByUsers = comment.getDislikedByUsers();
        Set<UserProfile> likedByUsers = comment.getLikedByUsers();
        if (!dislikedByUsers.contains(userProfile)) {
            if (likedByUsers.contains(userProfile)) {
                dislikedByUsers.add(userProfile);
                likedByUsers.remove(userProfile);
            } else {
                dislikedByUsers.add(userProfile);
            }
        } else {
            dislikedByUsers.remove(userProfile);
        }
        commentRepository.save(comment);
    }

    @Override
    public Long getCommentLikeCount(Long commentId) {
        return commentRepository.getCommentLikeCount(commentId);
    }

    @Override
    public Long getCommentDislikeCount(Long commentId) {
        return commentRepository.getCommentDislikeCount(commentId);
    }
}
