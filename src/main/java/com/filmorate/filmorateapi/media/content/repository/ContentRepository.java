package com.filmorate.filmorateapi.media.content.repository;

import com.filmorate.filmorateapi.media.content.model.Content;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    List<Content> findAllByMovie(Movie movie);

    void removeAllByMovie(Movie movie);
}
