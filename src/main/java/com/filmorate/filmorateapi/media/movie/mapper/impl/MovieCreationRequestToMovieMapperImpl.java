package com.filmorate.filmorateapi.media.movie.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.career.mapper.CareerFromStringMapper;
import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.genre.mapper.GenreFromStringMapper;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.movie.mapper.MovieCreationRequestToMovieMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
import com.filmorate.filmorateapi.media.person.mapper.PersonFromStringMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MovieCreationRequestToMovieMapperImpl implements MovieCreationRequestToMovieMapper {
    private final GenreFromStringMapper genreFromStringMapper;
    private final PersonFromStringMapper personFromStringMapper;
    private final JsonNullableMapper jsonNullableMapper;
    private final CareerFromStringMapper careerFromStringMapper;
    private final PersonService personService;

    @Override
    public Movie map(MovieCreationRequest request) {
        Movie movie = Movie.builder()
                .posterUrl(request.posterUrl())
                .title(request.title())
                .enTitle(request.enTitle())
                .description(request.description())
                .enDescription(request.enDescription())
                .releaseYear(request.releaseYear())
                .country(request.country())
                .duration(request.duration())
                .build();
        if (jsonNullableMapper.isPresent(request.genres())) {
            movie.setGenres(parseGenres(jsonNullableMapper.unwrap(request.genres())));
        }
        if (jsonNullableMapper.isPresent(request.director())) {
            movie.setDirector(parseDirector(jsonNullableMapper.unwrap(request.director())));
        }
        return movie;
    }

    private Set<Genre> parseGenres(Set<String> genres) {
        return genres.stream()
                .map(genreFromStringMapper::map)
                .collect(Collectors.toSet());
    }

    private Person parseDirector(String director) {
        Person person = personFromStringMapper.map(director);
        Set<Career> careers = person.getCareers();
        if (careers != null && careers.stream().noneMatch(career -> career.getName().equals("director"))) {
            careers.add(careerFromStringMapper.map("director"));
        }
        return personService.updatePerson(person);
    }
}
