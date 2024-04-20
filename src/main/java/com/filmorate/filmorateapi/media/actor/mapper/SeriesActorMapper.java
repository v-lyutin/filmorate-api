package com.filmorate.filmorateapi.media.actor.mapper;

import com.filmorate.filmorateapi.media.actor.model.MovieActor;
import com.filmorate.filmorateapi.media.actor.model.SeriesActor;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorCreationRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorUpdateRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.response.SeriesActorPageResponse;
import com.filmorate.filmorateapi.media.actor.web.dto.response.SeriesActorResponse;
import com.filmorate.filmorateapi.media.series.model.Series;
import org.springframework.data.domain.Page;
import java.util.List;

public interface SeriesActorMapper {
    SeriesActorResponse map(SeriesActor actor);

    List<SeriesActor> map(Series series, List<ActorCreationRequest> requests);

    List<SeriesActorResponse> map(List<SeriesActor> actors);

    SeriesActorPageResponse map(Page<SeriesActor> pageableActors);

    void update(SeriesActor actor, ActorUpdateRequest request);
}
