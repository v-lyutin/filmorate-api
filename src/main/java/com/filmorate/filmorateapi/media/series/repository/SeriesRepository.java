package com.filmorate.filmorateapi.media.series.repository;

import com.filmorate.filmorateapi.media.series.model.Series;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long>, JpaSpecificationExecutor<Series> {
    @Query("SELECT COUNT(l) FROM Series s LEFT JOIN s.likedByUsers l WHERE s.id = :id")
    Long getSeriesLikeCount(@Param("id") Long id);

    @Query("SELECT m FROM Series m LEFT JOIN m.likedByUsers u GROUP BY m.id ORDER BY COUNT(u) DESC")
    Page<Series> findAllOrderByLikes(Pageable pageable);
}
