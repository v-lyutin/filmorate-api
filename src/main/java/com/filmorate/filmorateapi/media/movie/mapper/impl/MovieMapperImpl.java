package com.filmorate.filmorateapi.media.movie.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.genre.mapper.GenreFromStringMapper;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.movie.mapper.MovieMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieUpdateRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieCreationResponse;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MoviePreviewResponse;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieResponse;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MoviesPageResponse;
import com.filmorate.filmorateapi.media.rating.mapper.MPAARatingMapper;
import com.filmorate.filmorateapi.media.rating.mapper.RARSRatingMapper;
import com.filmorate.filmorateapi.media.rating.model.MPAARating;
import com.filmorate.filmorateapi.media.rating.model.RARSRating;
import com.filmorate.filmorateapi.media.rating.service.MPAARatingService;
import com.filmorate.filmorateapi.media.rating.service.RARSRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MovieMapperImpl implements MovieMapper {
    private final GenreFromStringMapper genreFromStringMapper;
    private final MovieService movieService;
    private final MPAARatingMapper mpaaRatingMapper;
    private final RARSRatingMapper rarsRatingMapper;
    private final MPAARatingService mpaaRatingService;
    private final RARSRatingService rarsRatingService;
    private final JsonNullableMapper jsonNullableMapper;

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
                movie.getDuration(),
                mpaaRatingMapper.map(movie.getMpaaRating()),
                rarsRatingMapper.map(movie.getRarsRating())
        );
    }

    @Override
    public Movie map(MovieCreationRequest request) {
        MPAARating mpaaRating = mpaaRatingService.getByName(request.mpaaRating());
        RARSRating rarsRating = rarsRatingService.getByName(request.rarsRating());
        return Movie.builder()
                .posterUrl(request.posterUrl())
                .title(request.title())
                .originalTitle(request.originalTitle())
                .description(request.description())
                .releaseYear(request.releaseYear())
                .country(request.country())
                .duration(request.duration())
                .genres(parseGenres(request.genres()))
                .mpaaRating(mpaaRating)
                .rarsRating(rarsRating)
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
                movie.getDuration(),
                mpaaRatingMapper.map(movie.getMpaaRating()),
                rarsRatingMapper.map(movie.getRarsRating()),
                movieService.getMovieLikeCount(movie.getId())
        );
    }

    @Override
    public MoviesPageResponse toMoviesPageResponse(Page<Movie> movies) {
        List<MoviePreviewResponse> moviePreviews = movies.getContent().stream()
                .map(this::toMoviePreviewResponse)
                .toList();
        return new MoviesPageResponse(
                movies.getTotalPages(),
                movies.isFirst(),
                movies.isLast(),
                movies.getTotalElements(),
                moviePreviews
        );
    }

    @Override
    public void update(Movie movie, MovieUpdateRequest request) {
        if (request != null) {
            if (jsonNullableMapper.isPresent(request.genres())) {
                Set<Genre> genres = parseGenres(jsonNullableMapper.unwrap(request.genres()));
                movie.setGenres(genres);
            }
            if (jsonNullableMapper.isPresent(request.posterUrl())) {
                movie.setPosterUrl(jsonNullableMapper.unwrap(request.posterUrl()));
            }
            if (jsonNullableMapper.isPresent(request.title())) {
                movie.setTitle(jsonNullableMapper.unwrap(request.title()));
            }
            if (jsonNullableMapper.isPresent(request.originalTitle())) {
                movie.setOriginalTitle(jsonNullableMapper.unwrap(request.originalTitle()));
            }
            if (jsonNullableMapper.isPresent(request.description())) {
                movie.setDescription(jsonNullableMapper.unwrap(request.description()));
            }
            if (jsonNullableMapper.isPresent(request.releaseYear())) {
                movie.setReleaseYear(jsonNullableMapper.unwrap(request.releaseYear()));
            }
            if (jsonNullableMapper.isPresent(request.country())) {
                movie.setCountry(jsonNullableMapper.unwrap(request.country()));
            }
            if (jsonNullableMapper.isPresent(request.duration())) {
                movie.setDuration(jsonNullableMapper.unwrap(request.duration()));
            }
            if (jsonNullableMapper.isPresent(request.duration())) {
                RARSRating rarsRating = rarsRatingService.getByName(jsonNullableMapper.unwrap(request.rarsRating()));
                movie.setRarsRating(rarsRating);
            }
            if (jsonNullableMapper.isPresent(request.mpaaRating())) {
                MPAARating mpaaRating = mpaaRatingService.getByName(jsonNullableMapper.unwrap(request.mpaaRating()));
                movie.setMpaaRating(mpaaRating);
            }
            if (jsonNullableMapper.isPresent(request.duration())) {
                RARSRating rarsRating = rarsRatingService.getByName(jsonNullableMapper.unwrap(request.rarsRating()));
                movie.setRarsRating(rarsRating);
            }
        }
    }

    private MoviePreviewResponse toMoviePreviewResponse(Movie movie) {
        return new MoviePreviewResponse(
                movie.getId(),
                movie.getPosterUrl(),
                movie.getTitle(),
                movie.getOriginalTitle(),
                genresToGenreResponses(movie.getGenres()),
                movie.getDuration(),
                movie.getMpaaRating().getName(),
                movie.getRarsRating().getName(),
                movieService.getMovieLikeCount(movie.getId())
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
