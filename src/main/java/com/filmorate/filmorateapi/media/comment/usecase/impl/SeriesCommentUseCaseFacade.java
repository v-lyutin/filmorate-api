package com.filmorate.filmorateapi.media.comment.usecase.impl;

import com.filmorate.filmorateapi.media.comment.mapper.CommentMapper;
import com.filmorate.filmorateapi.media.comment.model.Comment;
import com.filmorate.filmorateapi.media.comment.model.SeriesComment;
import com.filmorate.filmorateapi.media.comment.service.CommentService;
import com.filmorate.filmorateapi.media.comment.service.SeriesCommentService;
import com.filmorate.filmorateapi.media.comment.usecase.SeriesCommentUseCase;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentPageRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentPageResponse;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentResponse;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.service.SeriesService;
import com.filmorate.filmorateapi.user.model.UserProfile;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeriesCommentUseCaseFacade implements SeriesCommentUseCase {
    private final CommentService commentService;
    private final CommentMapper commentMapper;
    private final SeriesCommentService seriesCommentService;
    private final SeriesService seriesService;
    private final CommentCommonUseCaseFacade commentCommonUseCaseFacade;

    @Override
    @Transactional
    public CommentResponse createComment(Long seriesId, CommentRequest request) {
        UserProfile userProfile = commentCommonUseCaseFacade.getOwner();
        Series series = seriesService.getSeriesById(seriesId);
        Comment comment = commentService.createComment(commentMapper.map(userProfile, request));
        SeriesComment seriesComment = SeriesComment.builder()
                .series(series)
                .comment(comment)
                .build();
        seriesCommentService.createSeriesComment(seriesComment);
        return commentMapper.map(comment);
    }

    @Override
    public CommentResponse updateComment(Long commentId, CommentRequest request) {
        return commentCommonUseCaseFacade.updateComment(commentId, request);
    }

    @Override
    public CommentPageResponse getCommentsBySeries(Long seriesId, CommentPageRequest request) {
        Series series = seriesService.getSeriesById(seriesId);
        Pageable pageable = PageRequest.of(request.page(), request.limit());
        return commentMapper.commentPageFromSeriesComments(seriesCommentService.getCommentsBySeries(series, pageable));
    }

    @Override
    public CommentResponse getCommentById(Long commentId) {
        return commentCommonUseCaseFacade.getCommentById(commentId);
    }

    @Override
    public void removeCommentById(Long commentId) {
        commentCommonUseCaseFacade.removeCommentById(commentId);
    }

    @Override
    public void removeAllCommentsBySeries(Long seriesId) {
        Series series = seriesService.getSeriesById(seriesId);
        seriesCommentService.removeAllCommentsBySeries(series);
    }
}
