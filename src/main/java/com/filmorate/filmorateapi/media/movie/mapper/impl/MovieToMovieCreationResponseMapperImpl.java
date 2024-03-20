package com.filmorate.filmorateapi.media.movie.mapper.impl;

import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.movie.mapper.MovieToMovieCreationResponseMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieCreationResponse;
import com.filmorate.filmorateapi.media.person.mapper.PersonToPersonDemoResponseMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonDemoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MovieToMovieCreationResponseMapperImpl implements MovieToMovieCreationResponseMapper {
    private final PersonToPersonDemoResponseMapper personToPersonDemoResponseMapper;

    @Override
    public MovieCreationResponse map(Movie movie) {
        return new MovieCreationResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getEnTitle(),
                movie.getDescription(),
                movie.getEnDescription(),
                movie.getReleaseYear(),
                movie.getCountry(),
                genresToGenreResponses(movie.getGenres()),
                directorToPersonDemoResponse(movie.getDirector()),
                movie.getDuration(),
                movie.getPosterUrl(),
                movie.getCreatedAt()
        );
    }

    private List<String> genresToGenreResponses(Set<Genre> genres) {
        if (genres == null) {
            return null;
        }
        return genres.stream()
                .map(Genre::getName)
                .collect(Collectors.toList());
    }

    private PersonDemoResponse directorToPersonDemoResponse(Person director) {
        if (director == null) {
            return null;
        }
        return personToPersonDemoResponseMapper.map(director);
    }
}
