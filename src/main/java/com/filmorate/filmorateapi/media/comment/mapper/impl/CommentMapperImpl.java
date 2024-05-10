package com.filmorate.filmorateapi.media.comment.mapper.impl;

import com.filmorate.filmorateapi.media.comment.mapper.CommentMapper;
import com.filmorate.filmorateapi.media.comment.model.Comment;
import com.filmorate.filmorateapi.media.comment.model.EpisodeComment;
import com.filmorate.filmorateapi.media.comment.model.MovieComment;
import com.filmorate.filmorateapi.media.comment.model.SeriesComment;
import com.filmorate.filmorateapi.media.comment.service.CommentService;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentPageResponse;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentResponse;
import com.filmorate.filmorateapi.user.model.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentMapperImpl implements CommentMapper {
    private final CommentService commentService;

    @Override
    public Comment map(UserProfile userProfile, CommentRequest commentRequest) {
        return Comment.builder()
                .text(commentRequest.text())
                .userProfile(userProfile)
                .build();
    }

    @Override
    public CommentResponse map(Comment comment) {
        UserProfile userProfile = comment.getUserProfile();
        return new CommentResponse(
                comment.getId(),
                userProfile.getId(),
                userProfile.getImageLink(),
                userProfile.getNickname(),
                comment.getText(),
                comment.getCreatedAt(),
                comment.getEditedAt(),
                commentService.getCommentLikeCount(comment.getId()),
                commentService.getCommentDislikeCount(comment.getId())

        );
    }

    @Override
    public CommentPageResponse commentPageFromMovieComments(Page<MovieComment> comments) {
        List<CommentResponse> commentResponses = comments.getContent().stream()
                .map(MovieComment::getComment)
                .map(this::map)
                .toList();
        return new CommentPageResponse(
                comments.getTotalPages(),
                comments.isFirst(),
                comments.isLast(),
                comments.getTotalElements(),
                commentResponses
        );
    }

    @Override
    public CommentPageResponse commentPageFromSeriesComments(Page<SeriesComment> comments) {
        List<CommentResponse> commentResponses = comments.getContent().stream()
                .map(SeriesComment::getComment)
                .map(this::map)
                .toList();
        return new CommentPageResponse(
                comments.getTotalPages(),
                comments.isFirst(),
                comments.isLast(),
                comments.getTotalElements(),
                commentResponses
        );
    }

    @Override
    public CommentPageResponse commentPageFromEpisodeComments(Page<EpisodeComment> comments) {
        List<CommentResponse> commentResponses = comments.getContent().stream()
                .map(EpisodeComment::getComment)
                .map(this::map)
                .toList();
        return new CommentPageResponse(
                comments.getTotalPages(),
                comments.isFirst(),
                comments.isLast(),
                comments.getTotalElements(),
                commentResponses
        );
    }
}
