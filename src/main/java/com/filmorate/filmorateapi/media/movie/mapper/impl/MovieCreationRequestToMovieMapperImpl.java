package com.filmorate.filmorateapi.media.movie.mapper.impl;

import com.filmorate.filmorateapi.media.genre.mapper.GenreFromStringMapper;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.movie.mapper.MovieCreationRequestToMovieMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MovieCreationRequestToMovieMapperImpl implements MovieCreationRequestToMovieMapper {
    private final GenreFromStringMapper genreFromStringMapper;

    @Override
    public Movie map(MovieCreationRequest request) {
        return Movie.builder()
                .posterUrl(request.posterUrl())
                .title(request.title())
                .enTitle(request.enTitle())
                .description(request.description())
                .enDescription(request.enDescription())
                .releaseYear(request.releaseYear())
                .country(request.country())
                .genres(parseGenres(request.genres()))
                .duration(request.duration())
                .build();
    }

    private Set<Genre> parseGenres(Set<String> genres) {
        return genres.stream()
                .map(genreFromStringMapper::map)
                .collect(Collectors.toSet());
    }
}
