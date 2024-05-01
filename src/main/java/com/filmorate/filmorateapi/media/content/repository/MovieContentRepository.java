package com.filmorate.filmorateapi.media.content.repository;

import com.filmorate.filmorateapi.media.content.model.MovieContent;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieContentRepository extends JpaRepository<MovieContent, Long> {
    List<MovieContent> findAllByMovie(Movie movie);

    List<MovieContent> findAllByMovieAndContentType(Movie movie, ContentType contentType);

    void removeAllByMovie(Movie movie);
}
