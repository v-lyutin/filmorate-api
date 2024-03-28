package com.filmorate.filmorateapi.media.actor.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.actor.mapper.MovieActorMapper;
import com.filmorate.filmorateapi.media.actor.model.MovieActor;
import com.filmorate.filmorateapi.media.actor.web.dto.request.MovieActorCreationRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.request.MovieActorUpdateRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.response.MovieActorPageResponse;
import com.filmorate.filmorateapi.media.actor.web.dto.response.MovieActorResponse;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.person.mapper.PersonToPersonDemoResponseMapper;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MovieActorMapperImpl implements MovieActorMapper {
    private final PersonService personService;
    private final PersonToPersonDemoResponseMapper personMapper;
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public MovieActorResponse map(MovieActor actor) {
        return new MovieActorResponse(
                actor.getId(),
                actor.getMovie().getId(),
                personMapper.map(actor.getPerson()),
                actor.getRole(),
                actor.getIsMainRole()
        );
    }

    @Override
    public List<MovieActor> map(Movie movie, List<MovieActorCreationRequest> requests) {
        return requests.stream()
                .map(movieActorRequest -> MovieActor.builder()
                        .person(personService.getPersonById(movieActorRequest.personId()))
                        .movie(movie)
                        .role(movieActorRequest.role())
                        .isMainRole(movieActorRequest.isMainRole())
                        .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieActorResponse> map(List<MovieActor> actors) {
        return actors.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public MovieActorPageResponse map(Page<MovieActor> pageableActors) {
        return new MovieActorPageResponse(
                pageableActors.getTotalPages(),
                pageableActors.isFirst(),
                pageableActors.isLast(),
                pageableActors.getTotalElements(),
                map(pageableActors.getContent())
        );
    }

    @Override
    public void update(MovieActor actor, MovieActorUpdateRequest request) {
        if (request == null) {
            return;
        }
        if (jsonNullableMapper.isPresent(request.role())) {
            actor.setRole(jsonNullableMapper.unwrap(request.role()));
        }
        if (jsonNullableMapper.isPresent(request.isMainRole())) {
            actor.setIsMainRole(jsonNullableMapper.unwrap(request.isMainRole()));
        }
    }
}
