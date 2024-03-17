package com.filmorate.filmorateapi.media.movie.mapper.impl;

import com.filmorate.filmorateapi.media.genre.mapper.GenreToGenreResponseMapper;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.genre.web.dto.GenreResponse;
import com.filmorate.filmorateapi.media.movie.mapper.MovieToMovieCreationResponseMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieCreationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MovieToMovieCreationResponseMapperImpl implements MovieToMovieCreationResponseMapper {
    private final GenreToGenreResponseMapper genreToGenreResponseMapper;

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
                movie.getDuration(),
                movie.getPosterUrl(),
                movie.getCreatedAt()
        );
    }

    private Set<GenreResponse> genresToGenreResponses(Set<Genre> genres) {
        return genres.stream()
                .map(genreToGenreResponseMapper::map)
                .collect(Collectors.toSet());
    }
}
