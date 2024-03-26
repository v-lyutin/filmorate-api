package com.filmorate.filmorateapi.media.movie.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.career.mapper.CareerFromStringMapper;
import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.content.mapper.ContentMapper;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.service.ContentService;
import com.filmorate.filmorateapi.media.content.web.dto.response.ContentResponse;
import com.filmorate.filmorateapi.media.genre.mapper.GenreFromStringMapper;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.movie.mapper.MovieMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieCreationResponse;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieResponse;
import com.filmorate.filmorateapi.media.person.mapper.PersonFromStringMapper;
import com.filmorate.filmorateapi.media.person.mapper.PersonToPersonDemoResponseMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonDemoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MovieMapperImpl implements MovieMapper {
    private final GenreFromStringMapper genreFromStringMapper;
    private final PersonFromStringMapper personFromStringMapper;
    private final JsonNullableMapper jsonNullableMapper;
    private final CareerFromStringMapper careerFromStringMapper;
    private final PersonToPersonDemoResponseMapper personToPersonDemoResponseMapper;
    private final ContentMapper contentMapper;
    private final ContentService contentService;
    private final PersonService personService;

    @Override
    public MovieCreationResponse map(Movie movie) {
        return new MovieCreationResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getEnTitle(),
                movie.getDescription(),
                movie.getReleaseYear(),
                movie.getCountry(),
                genresToGenreResponses(movie.getGenres()),
                directorToPersonDemoResponse(movie.getDirector()),
                actorsToPeronResponses(movie.getActors()),
                movie.getDuration(),
                movie.getPosterUrl(),
                movie.getCreatedAt()
        );
    }

    @Override
    public Movie map(MovieCreationRequest request) {
        Movie movie = Movie.builder()
                .posterUrl(request.posterUrl())
                .title(request.title())
                .enTitle(request.enTitle())
                .description(request.description())
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
        if (jsonNullableMapper.isPresent(request.actors())) {
            movie.setActors(parseActors(jsonNullableMapper.unwrap(request.actors())));
        }
        return movie;
    }

    @Override
    public MovieResponse toMovieResponse(Movie movie) {
        return new MovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getEnTitle(),
                movie.getDescription(),
                movie.getReleaseYear(),
                movie.getCountry(),
                genresToGenreResponses(movie.getGenres()),
                directorToPersonDemoResponse(movie.getDirector()),
                actorsToPeronResponses(movie.getActors()),
                movie.getDuration(),
                movie.getPosterUrl(),
                movie.getCreatedAt()
        );
    }

    private Set<Genre> parseGenres(Set<String> genres) {
        return genres.stream()
                .map(genreFromStringMapper::map)
                .collect(Collectors.toSet());
    }

    private Set<Person> parseActors(Set<String> actors) {
        return actors.stream()
                .map(personFromStringMapper::map)
                .map(person -> {
                    Set<Career> careers = person.getCareers();
                    if (careers != null && careers.stream().noneMatch(career -> career.getName().equals("actor"))) {
                        careers.add(careerFromStringMapper.map("actor"));
                        return personService.updatePerson(person);
                    }
                    return person;
                })
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

    private List<String> genresToGenreResponses(Set<Genre> genres) {
        if (genres == null) {
            return null;
        }
        return genres.stream()
                .map(Genre::getName)
                .collect(Collectors.toList());
    }

    private List<PersonDemoResponse> actorsToPeronResponses(Set<Person> actors) {
        if (actors == null) {
            return null;
        }
        return actors.stream()
                .map(personToPersonDemoResponseMapper::map)
                .collect(Collectors.toList());
    }

    private PersonDemoResponse directorToPersonDemoResponse(Person director) {
        if (director == null) {
            return null;
        }
        return personToPersonDemoResponseMapper.map(director);
    }
}
