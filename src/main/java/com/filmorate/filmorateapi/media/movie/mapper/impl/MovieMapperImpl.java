package com.filmorate.filmorateapi.media.movie.mapper.impl;

import com.filmorate.filmorateapi.media.genre.mapper.GenreFromStringMapper;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.movie.mapper.MovieMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieCreationResponse;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MovieMapperImpl implements MovieMapper {
    private final GenreFromStringMapper genreFromStringMapper;

    @Override
    public MovieCreationResponse map(Movie movie) {
        return new MovieCreationResponse(
                movie.getId(),
                movie.getPosterUrl(),
                movie.getTitle(),
                movie.getOriginalTitle(),
                movie.getDescription(),
                movie.getReleaseYear(),
                movie.getCountry(),
                genresToGenreResponses(movie.getGenres()),
                movie.getDuration()
        );
    }

    @Override
    public Movie map(MovieCreationRequest request) {
        return Movie.builder()
                .title(request.title())
                .originalTitle(request.originalTitle())
                .description(request.description())
                .releaseYear(request.releaseYear())
                .country(request.country())
                .duration(request.duration())
                .genres(parseGenres(request.genres()))
                .build();
    }

    @Override
    public MovieResponse toMovieResponse(Movie movie) {
        return new MovieResponse(
                movie.getId(),
                movie.getPosterUrl(),
                movie.getTitle(),
                movie.getOriginalTitle(),
                movie.getDescription(),
                movie.getReleaseYear(),
                movie.getCountry(),
                genresToGenreResponses(movie.getGenres()),
                movie.getDuration()
        );
    }

    private Set<Genre> parseGenres(Set<String> genres) {
        return genres.stream()
                .map(genreFromStringMapper::map)
                .collect(Collectors.toSet());
    }

    private List<String> genresToGenreResponses(Set<Genre> genres) {
        if (genres == null) {
            return null;
        }
        return genres.stream()
                .map(Genre::getName)
                .collect(Collectors.toList());
    }
}
