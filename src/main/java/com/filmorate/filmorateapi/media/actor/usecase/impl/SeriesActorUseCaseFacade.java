package com.filmorate.filmorateapi.media.actor.usecase.impl;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.actor.mapper.SeriesActorMapper;
import com.filmorate.filmorateapi.media.actor.model.SeriesActor;
import com.filmorate.filmorateapi.media.actor.model.SeriesActor_;
import com.filmorate.filmorateapi.media.actor.service.SeriesActorService;
import com.filmorate.filmorateapi.media.actor.usecase.SeriesActorUseCase;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorCreationRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorUpdateRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.response.SeriesActorPageResponse;
import com.filmorate.filmorateapi.media.actor.web.dto.response.SeriesActorResponse;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.service.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SeriesActorUseCaseFacade implements SeriesActorUseCase {
    private final SeriesActorService seriesActorService;
    private final SeriesService seriesService;
    private final SeriesActorMapper actorMapper;

    @Override
    public List<SeriesActorResponse> createActors(Long seriesId, List<ActorCreationRequest> request) {
        Series series = seriesService.getSeriesById(seriesId);
        List<SeriesActor> createdActors = seriesActorService.createActors(actorMapper.map(series, request));
        return actorMapper.map(createdActors);
    }

    @Override
    public SeriesActorResponse updateActorById(Long actorId, ActorUpdateRequest request) {
        SeriesActor actor = seriesActorService.getActorById(actorId);
        actorMapper.update(actor, request);
        return actorMapper.map(seriesActorService.updateActor(actor));
    }

    @Override
    public SeriesActorPageResponse getActorsBySeries(Long seriesId, PageFindRequest request) {
        Series series = seriesService.getSeriesById(seriesId);
        Pageable pageable = PageRequest.of(request.page(), request.limit(), Sort.by(SeriesActor_.IS_MAIN_ROLE).descending());
        Page<SeriesActor> actors = seriesActorService.getActorsBySeries(series, pageable);
        return actorMapper.map(actors);
    }

    @Override
    public SeriesActorResponse getActorById(Long actorId) {
        return actorMapper.map(seriesActorService.getActorById(actorId));
    }

    @Override
    public void removeActorById(Long actorId) {
        seriesActorService.removeActorById(actorId);
    }

    @Override
    public void removeAllActorsByMovieId(Long seriesId) {
        Series series = seriesService.getSeriesById(seriesId);
        seriesActorService.removeAllActorsBySeries(series);
    }
}
