package com.filmorate.filmorateapi.media.comment.repository;

import com.filmorate.filmorateapi.media.comment.model.MovieComment;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCommentRepository extends JpaRepository<MovieComment, Long> {
    Page<MovieComment> findAllByMovie(Movie movie, Pageable pageable);

    void removeAllByMovie(Movie movie);
}
