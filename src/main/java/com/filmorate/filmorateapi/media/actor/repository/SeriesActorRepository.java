package com.filmorate.filmorateapi.media.actor.repository;

import com.filmorate.filmorateapi.media.actor.model.SeriesActor;
import com.filmorate.filmorateapi.media.series.model.Series;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesActorRepository extends JpaRepository<SeriesActor, Long> {
    Page<SeriesActor> findAllBySeries(Series series, Pageable pageable);

    void deleteAllBySeries(Series series);
}
