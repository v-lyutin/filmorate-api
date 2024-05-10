package com.filmorate.filmorateapi.media.comment.usecase.impl;

import com.filmorate.filmorateapi.media.comment.mapper.CommentMapper;
import com.filmorate.filmorateapi.media.comment.model.Comment;
import com.filmorate.filmorateapi.media.comment.model.MovieComment;
import com.filmorate.filmorateapi.media.comment.service.CommentService;
import com.filmorate.filmorateapi.media.comment.service.MovieCommentService;
import com.filmorate.filmorateapi.media.comment.usecase.MovieCommentUseCase;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentPageRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentPageResponse;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentResponse;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import com.filmorate.filmorateapi.user.model.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class MovieCommentUseCaseFacade implements MovieCommentUseCase {
    private final CommentService commentService;
    private final CommentMapper commentMapper;
    private final MovieService movieService;
    private final MovieCommentService movieCommentService;
    private final CommentCommonUseCaseFacade commentCommonUseCaseFacade;

    @Override
    @Transactional
    public CommentResponse createComment(Long movieId, CommentRequest request) {
        UserProfile userProfile = commentCommonUseCaseFacade.getOwner();
        Movie movie = movieService.getMovieById(movieId);
        Comment comment = commentService.createComment(commentMapper.map(userProfile, request));
        MovieComment movieComment = MovieComment.builder()
                .movie(movie)
                .comment(comment)
                .build();
        movieCommentService.createMovieComment(movieComment);
        return commentMapper.map(comment);
    }

    @Override
    public CommentPageResponse getCommentsByMovie(Long movieId, CommentPageRequest request) {
        Movie movie = movieService.getMovieById(movieId);
        Pageable pageable = PageRequest.of(request.page(), request.limit());
        return commentMapper.commentPageFromMovieComments(movieCommentService.getCommentsByMovie(movie, pageable));
    }

    @Override
    public void removeAllCommentsByMovie(Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        movieCommentService.removeAllCommentsByMovie(movie);
    }
}
