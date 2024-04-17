package com.filmorate.filmorateapi.media.fact.mapper.impl;

import com.filmorate.filmorateapi.media.fact.mapper.FactMapper;
import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.model.FactType;
import com.filmorate.filmorateapi.media.fact.web.dto.FactRequest;
import com.filmorate.filmorateapi.media.fact.web.dto.FactResponse;
import com.filmorate.filmorateapi.media.movie.exception.MovieServiceException;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import com.filmorate.filmorateapi.media.person.exception.PersonServiceException;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FactMapperImpl implements FactMapper {
    private final PersonService personService;
    private final MovieService movieService;

    @Override
    public Fact map(FactType factType, FactRequest request) {
        if (factType == FactType.MOVIE) {
            boolean isMovieExists = movieService.existsById(request.entityId());
            if (!isMovieExists) {
                throw new MovieServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Movie with ID = %d not found", request.entityId()));
            }
            return Fact.builder()
                    .entityId(request.entityId())
                    .factType(factType)
                    .text(request.text())
                    .build();
        }
        boolean isPersonExists = personService.existsById(request.entityId());
        if (!isPersonExists) {
            throw new PersonServiceException(
                    HttpStatus.NOT_FOUND,
                    String.format("Person with ID = %d not found", request.entityId()));
        }
        return Fact.builder()
                .entityId(request.entityId())
                .factType(factType)
                .text(request.text())
                .build();
    }

    @Override
    public FactResponse map(Fact fact) {
        return new FactResponse(
                fact.getId(),
                fact.getFactType(),
                fact.getEntityId(),
                fact.getText(),
                fact.getCreatedAt(),
                fact.getEditedAt());
    }
}
