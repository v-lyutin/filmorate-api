package com.filmorate.filmorateapi.media.compilation.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.compilation.mapper.CompilationMapper;
import com.filmorate.filmorateapi.media.compilation.model.Compilation;
import com.filmorate.filmorateapi.media.compilation.service.CompilationService;
import com.filmorate.filmorateapi.media.compilation.web.dto.request.CompilationCreationRequest;
import com.filmorate.filmorateapi.media.compilation.web.dto.request.CompilationUpdateRequest;
import com.filmorate.filmorateapi.media.compilation.web.dto.response.CompilationPageResponse;
import com.filmorate.filmorateapi.media.compilation.web.dto.response.CompilationPreviewResponse;
import com.filmorate.filmorateapi.media.compilation.web.dto.response.CompilationResponse;
import com.filmorate.filmorateapi.media.genre.mapper.GenreMapper;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.movie.mapper.MovieMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MoviePreviewResponse;
import com.filmorate.filmorateapi.media.series.mapper.SeriesMapper;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesPreviewResponse;
import com.filmorate.filmorateapi.user.mapper.UserProfileMapper;
import com.filmorate.filmorateapi.user.web.dto.response.UserProfilePreviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompilationMapperImpl implements CompilationMapper {
    private final UserProfileMapper userProfileMapper;
    private final GenreMapper genreMapper;
    private final CompilationService compilationService;
    private final MovieMapper movieMapper;
    private final SeriesMapper seriesMapper;
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public Compilation toCompilation(CompilationCreationRequest request) {
        return Compilation.builder()
                .title(request.title())
                .description(request.description())
                .genres(genreMapper.toGenres(request.genres()))
                .build();
    }

    @Override
    public CompilationResponse toCompilationResponse(Compilation compilation) {
        UserProfilePreviewResponse author = userProfileMapper.toUserProfilePreviewResponse(compilation.getUserProfile());
        Set<String> genres = genreMapper.toGenreNamesSet(compilation.getGenres());
        Set<MoviePreviewResponse> movies = checkMovies(compilation);
        Set<SeriesPreviewResponse> series = checkSeries(compilation);
        return new CompilationResponse(
                compilation.getId(),
                author,
                genres,
                compilation.getTitle(),
                compilation.getDescription(),
                movies,
                series,
                compilationService.getCompilationLikeCount(compilation.getId())
        );
    }

    @Override
    public CompilationPageResponse toCompilationPageResponse(Page<Compilation> pageableCompilations) {
        Set<CompilationPreviewResponse> compilationsPreviews = pageableCompilations.getContent().stream()
                .map(this::toCompilationPreviewResponse)
                .collect(Collectors.toSet());
        return new CompilationPageResponse(
                pageableCompilations.getTotalPages(),
                pageableCompilations.isFirst(),
                pageableCompilations.isLast(),
                pageableCompilations.getTotalElements(),
                compilationsPreviews
        );
    }

    @Override
    public void update(Compilation compilation, CompilationUpdateRequest request) {
        if (request == null) {
            return;
        }
        if (jsonNullableMapper.isPresent(request.title())) {
            compilation.setTitle(jsonNullableMapper.unwrap(request.title()));
        }
        if (jsonNullableMapper.isPresent(request.description())) {
            compilation.setDescription(jsonNullableMapper.unwrap(request.description()));
        }
        if (jsonNullableMapper.isPresent(request.genres())) {
            Set<Genre> genres = genreMapper.toGenres(jsonNullableMapper.unwrap(request.genres()));
            compilation.setGenres(genres);
        }
    }

    private CompilationPreviewResponse toCompilationPreviewResponse(Compilation compilation) {
        Set<String> genres = genreMapper.toGenreNamesSet(compilation.getGenres());
        return new CompilationPreviewResponse(
                compilation.getId(),
                userProfileMapper.toUserProfilePreviewResponse(compilation.getUserProfile()),
                genres,
                compilation.getTitle(),
                compilationService.getCompilationLikeCount(compilation.getId())
        );
    }

    private Set<MoviePreviewResponse> checkMovies(Compilation compilation) {
        Set<Movie> moviePreviews = compilation.getMovies();
        if (moviePreviews == null) {
            return null;
        }
        return moviePreviews.stream()
                .map(movieMapper::toMoviePreviewResponse)
                .collect(Collectors.toSet());
    }

    private Set<SeriesPreviewResponse> checkSeries(Compilation compilation) {
        Set<Series> seriesPreviews = compilation.getSeries();
        if (seriesPreviews == null) {
            return null;
        }
        return seriesPreviews.stream()
                .map(seriesMapper::toSeriesPreviewResponse)
                .collect(Collectors.toSet());
    }
}
