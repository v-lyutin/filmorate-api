package com.filmorate.filmorateapi.media.actor.usecase;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorCreationRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorUpdateRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.response.MovieActorPageResponse;
import com.filmorate.filmorateapi.media.actor.web.dto.response.MovieActorResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import java.util.List;

@Validated
public interface MovieActorUseCase {
    List<MovieActorResponse> createActors(Long movieId, List<ActorCreationRequest> request);

    MovieActorResponse updateActorById(Long actorId, ActorUpdateRequest request);

    MovieActorPageResponse getActorsByMovie(Long movieId, @Valid PageFindRequest request);

    MovieActorResponse getActorById(Long actorId);

    void removeActorById(Long actorId);

    void removeAllActorsByMovieId(Long movieId);
}
