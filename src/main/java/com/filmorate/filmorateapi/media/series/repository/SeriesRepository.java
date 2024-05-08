package com.filmorate.filmorateapi.media.series.repository;

import com.filmorate.filmorateapi.media.series.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long>, JpaSpecificationExecutor<Series> {
    @Query("SELECT COUNT(l) FROM Series s LEFT JOIN s.likedByUsers l WHERE s.id = :id")
    Long getSeriesLikeCount(@Param("id") Long id);
}
