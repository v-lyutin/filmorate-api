package com.filmorate.filmorateapi.media.series.repository;

import com.filmorate.filmorateapi.media.series.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {
}
