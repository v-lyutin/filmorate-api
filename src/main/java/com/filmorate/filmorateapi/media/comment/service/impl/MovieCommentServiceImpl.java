package com.filmorate.filmorateapi.media.comment.service.impl;

import com.filmorate.filmorateapi.media.comment.model.MovieComment;
import com.filmorate.filmorateapi.media.comment.repository.MovieCommentRepository;
import com.filmorate.filmorateapi.media.comment.service.MovieCommentService;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieCommentServiceImpl implements MovieCommentService {
    private final MovieCommentRepository movieCommentRepository;

    @Override
    public Page<MovieComment> getCommentsByMovie(Movie movie, Pageable pageable) {
        return movieCommentRepository.findAllByMovie(movie, pageable);
    }

    @Override
    public void createMovieComment(MovieComment movieComment) {
        movieCommentRepository.save(movieComment);
    }

    @Override
    public void removeAllCommentsByMovie(Movie movie) {
        movieCommentRepository.removeAllByMovie(movie);
    }
}
