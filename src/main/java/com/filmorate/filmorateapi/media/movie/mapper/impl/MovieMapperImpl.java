package com.filmorate.filmorateapi.media.movie.mapper.impl;

import com.filmorate.filmorateapi.media.genre.mapper.GenreFromStringMapper;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.movie.mapper.MovieMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
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
