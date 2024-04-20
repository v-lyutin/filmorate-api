package com.filmorate.filmorateapi.media.actor.service.impl;

import com.filmorate.filmorateapi.media.actor.exception.SeriesActorServiceException;
import com.filmorate.filmorateapi.media.actor.model.SeriesActor;
import com.filmorate.filmorateapi.media.actor.repository.SeriesActorRepository;
import com.filmorate.filmorateapi.media.actor.service.SeriesActorService;
import com.filmorate.filmorateapi.media.series.model.Series;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesActorServiceImpl implements SeriesActorService {
    private final SeriesActorRepository seriesActorRepository;

    @Override
    public List<SeriesActor> createActors(List<SeriesActor> actors) {
        return seriesActorRepository.saveAll(actors);
    }

    @Override
    public SeriesActor updateActor(SeriesActor actor) {
        return seriesActorRepository.save(actor);
    }

    @Override
    public SeriesActor getActorById(Long actorId) {
        return seriesActorRepository.findById(actorId)
                .orElseThrow(() -> new SeriesActorServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Actor with ID = '%d' not found", actorId)));
    }

    @Override
    public Page<SeriesActor> getActorsBySeries(Series series, Pageable pageable) {
        return seriesActorRepository.findAllBySeries(series, pageable);
    }

    @Override
    public void removeActorById(Long actorId) {
        seriesActorRepository.deleteById(actorId);
    }

    @Override
    @Transactional
    public void removeAllActorsBySeries(Series series) {
        seriesActorRepository.deleteAllBySeries(series);
    }
}
