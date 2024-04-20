package com.filmorate.filmorateapi.media.actor.mapper;

import com.filmorate.filmorateapi.media.actor.model.MovieActor;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorCreationRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorUpdateRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.response.MovieActorPageResponse;
import com.filmorate.filmorateapi.media.actor.web.dto.response.MovieActorResponse;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import org.springframework.data.domain.Page;
import java.util.List;

public interface MovieActorMapper {
    MovieActorResponse map(MovieActor actor);

    List<MovieActor> map(Movie movie, List<ActorCreationRequest> requests);

    List<MovieActorResponse> map(List<MovieActor> actors);

    MovieActorPageResponse map(Page<MovieActor> pageableActors);

    void update(MovieActor actor, ActorUpdateRequest request);
}
