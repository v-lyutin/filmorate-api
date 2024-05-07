package com.filmorate.filmorateapi.media.comment.usecase.impl;

import com.filmorate.filmorateapi.media.comment.mapper.CommentMapper;
import com.filmorate.filmorateapi.media.comment.model.Comment;
import com.filmorate.filmorateapi.media.comment.model.EpisodeComment;
import com.filmorate.filmorateapi.media.comment.service.CommentService;
import com.filmorate.filmorateapi.media.comment.service.EpisodeCommentService;
import com.filmorate.filmorateapi.media.comment.usecase.EpisodeCommentUseCase;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentPageRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentPageResponse;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentResponse;
import com.filmorate.filmorateapi.media.series.model.Episode;
import com.filmorate.filmorateapi.media.series.service.EpisodeService;
import com.filmorate.filmorateapi.user.model.UserProfile;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EpisodeCommentUseCaseFacade implements EpisodeCommentUseCase {
    private final CommentService commentService;
    private final CommentMapper commentMapper;
    private final EpisodeService episodeService;
    private final EpisodeCommentService episodeCommentService;
    private final CommentCommonUseCaseFacade commentCommonUseCaseFacade;

    @Override
    @Transactional
    public CommentResponse createComment(Long episodeId, CommentRequest request) {
        UserProfile userProfile = commentCommonUseCaseFacade.getOwner();
        Episode episode = episodeService.getEpisodeById(episodeId);
        Comment comment = commentService.createComment(commentMapper.map(userProfile, request));
        EpisodeComment episodeComment = EpisodeComment.builder()
                .episode(episode)
                .comment(comment)
                .build();
        episodeCommentService.createEpisodeComment(episodeComment);
        return commentMapper.map(comment);
    }

    @Override
    public CommentResponse updateComment(Long commentId, CommentRequest request) {
        return commentCommonUseCaseFacade.updateComment(commentId, request);
    }

    @Override
    public CommentPageResponse getCommentsByEpisode(Long episodeId, CommentPageRequest request) {
        Episode episode = episodeService.getEpisodeById(episodeId);
        Pageable pageable = PageRequest.of(request.page(), request.limit());
        return commentMapper.commentPageFromEpisodeComments(episodeCommentService.getCommentsByEpisode(episode, pageable));
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
    public void removeAllCommentsByEpisode(Long episodeId) {
        Episode episode = episodeService.getEpisodeById(episodeId);
        episodeCommentService.removeAllCommentsByEpisode(episode);
    }
}
