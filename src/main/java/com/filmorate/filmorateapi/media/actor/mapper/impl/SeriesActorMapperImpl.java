package com.filmorate.filmorateapi.media.actor.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.actor.mapper.SeriesActorMapper;
import com.filmorate.filmorateapi.media.actor.model.SeriesActor;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorCreationRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorUpdateRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.response.SeriesActorPageResponse;
import com.filmorate.filmorateapi.media.actor.web.dto.response.SeriesActorResponse;
import com.filmorate.filmorateapi.media.person.mapper.PersonMapper;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import com.filmorate.filmorateapi.media.series.model.Series;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SeriesActorMapperImpl implements SeriesActorMapper {
    private final PersonService personService;
    private final PersonMapper personMapper;
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public SeriesActorResponse map(SeriesActor actor) {
        return new SeriesActorResponse(
                actor.getId(),
                actor.getSeries().getId(),
                personMapper.toPersonPreviewResponse(actor.getPerson()),
                actor.getRole(),
                actor.getIsMainRole()
        );
    }

    @Override
    public List<SeriesActor> map(Series series, List<ActorCreationRequest> requests) {
        return requests.stream()
                .map(movieActorRequest -> SeriesActor.builder()
                        .person(personService.getPersonById(movieActorRequest.personId()))
                        .series(series)
                        .role(movieActorRequest.role())
                        .isMainRole(movieActorRequest.isMainRole())
                        .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<SeriesActorResponse> map(List<SeriesActor> actors) {
        return actors.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public SeriesActorPageResponse map(Page<SeriesActor> pageableActors) {
        return new SeriesActorPageResponse(
                pageableActors.getTotalPages(),
                pageableActors.isFirst(),
                pageableActors.isLast(),
                pageableActors.getTotalElements(),
                map(pageableActors.getContent())
        );
    }

    @Override
    public void update(SeriesActor actor, ActorUpdateRequest request) {
        if (request != null) {
            if (jsonNullableMapper.isPresent(request.role())) {
                actor.setRole(jsonNullableMapper.unwrap(request.role()));
            }
            if (jsonNullableMapper.isPresent(request.isMainRole())) {
                actor.setIsMainRole(jsonNullableMapper.unwrap(request.isMainRole()));
            }
        }
    }
}
