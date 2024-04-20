package com.filmorate.filmorateapi.media.actor.service;

import com.filmorate.filmorateapi.media.actor.model.SeriesActor;
import com.filmorate.filmorateapi.media.series.model.Series;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface SeriesActorService {
    List<SeriesActor> createActors(List<SeriesActor> actors);

    SeriesActor updateActor(SeriesActor actor);

    SeriesActor getActorById(Long actorId);

    Page<SeriesActor> getActorsBySeries(Series series, Pageable pageable);

    void removeActorById(Long actorId);

    void removeAllActorsBySeries(Series series);
}
