package com.filmorate.filmorateapi.media.actor.usecase;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorCreationRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorUpdateRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.response.SeriesActorPageResponse;
import com.filmorate.filmorateapi.media.actor.web.dto.response.SeriesActorResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import java.util.List;

@Validated
public interface SeriesActorUseCase {
    List<SeriesActorResponse> createActors(Long seriesId, List<ActorCreationRequest> request);

    SeriesActorResponse updateActorById(Long actorId, ActorUpdateRequest request);

    SeriesActorPageResponse getActorsBySeries(Long seriesId, @Valid PageFindRequest request);

    SeriesActorResponse getActorById(Long actorId);

    void removeActorById(Long actorId);

    void removeAllActorsByMovieId(Long seriesId);
}
