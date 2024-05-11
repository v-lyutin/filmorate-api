package com.filmorate.filmorateapi.media.compilation.usecase.impl;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.compilation.mapper.CompilationMapper;
import com.filmorate.filmorateapi.media.compilation.model.Compilation;
import com.filmorate.filmorateapi.media.compilation.service.CompilationService;
import com.filmorate.filmorateapi.media.compilation.usecase.CompilationUseCase;
import com.filmorate.filmorateapi.media.compilation.web.dto.request.CompilationCreationRequest;
import com.filmorate.filmorateapi.media.compilation.web.dto.request.CompilationUpdateRequest;
import com.filmorate.filmorateapi.media.compilation.web.dto.response.CompilationPageResponse;
import com.filmorate.filmorateapi.media.compilation.web.dto.response.CompilationResponse;
import com.filmorate.filmorateapi.media.movie.api.MovieApiService;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.series.api.SeriesApiService;
import com.filmorate.filmorateapi.media.series.model.Series;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Transactional
@RequiredArgsConstructor
public class CompilationUseCaseFacade implements CompilationUseCase {
    private final CompilationService compilationService;
    private final CompilationMapper compilationMapper;
    private final MovieApiService movieApiService;
    private final SeriesApiService seriesApiService;

    @Override
    public CompilationResponse createCompilation(CompilationCreationRequest request) {
        Compilation compilation = compilationMapper.toCompilation(request);
        return compilationMapper.toCompilationResponse(compilationService.createCompilation(compilation));
    }

    @Override
    public CompilationResponse updateCompilation(Long compilationId, CompilationUpdateRequest request) {
        Compilation compilation = compilationService.getCompilationById(compilationId);
        compilationMapper.update(compilation, request);
        return compilationMapper.toCompilationResponse(compilationService.updateCompilation(compilation));
    }

    @Override
    public CompilationPageResponse searchCompilations(PageFindRequest pageFindRequest) {
        Pageable pageable = PageRequest.of(pageFindRequest.page(), pageFindRequest.limit());
        return compilationMapper.toCompilationPageResponse(compilationService.searchCompilations(pageable));
    }

    @Override
    public CompilationResponse getCompilationById(Long compilationId) {
        return compilationMapper.toCompilationResponse(compilationService.getCompilationById(compilationId));
    }

    @Override
    public void removeCompilation(Long compilationId) {
        compilationService.removeCompilationById(compilationId);
    }

    @Override
    public void toggleLike(Long compilationId) {
        compilationService.toggleLike(compilationId);
    }

    @Override
    public void toggleMovie(Long compilationId, Long movieId) {
        Movie movie = movieApiService.getMovieById(movieId);
        compilationService.toggleMovie(compilationId, movie);
    }

    @Override
    public void toggleSeries(Long compilationId, Long seriesId) {
        Series series = seriesApiService.getSeriesById(seriesId);
        compilationService.toggleSeries(compilationId, series);
    }
}
