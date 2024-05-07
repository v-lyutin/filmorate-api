package com.filmorate.filmorateapi.media.comment.service;

import com.filmorate.filmorateapi.media.comment.model.MovieComment;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieCommentService {
    Page<MovieComment> getCommentsByMovie(Movie movie, Pageable pageable);

    void createMovieComment(MovieComment movieComment);

    void removeAllCommentsByMovie(Movie movie);
}
