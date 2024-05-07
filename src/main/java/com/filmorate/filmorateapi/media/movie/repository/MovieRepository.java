package com.filmorate.filmorateapi.media.movie.repository;

import com.filmorate.filmorateapi.media.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, JpaSpecificationExecutor<Movie> {
    @Query("SELECT COUNT(l) FROM Movie m LEFT JOIN m.likedByUsers l WHERE m.id = :id")
    Long getMovieLikeCount(@Param("id") Long id);
}
