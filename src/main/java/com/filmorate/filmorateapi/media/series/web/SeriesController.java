package com.filmorate.filmorateapi.media.series.web;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.series.usecase.SeriesUseCase;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesFindRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesPageResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/series")
public class SeriesController {
    private final SeriesUseCase seriesUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public SeriesResponse addSeries(@Valid @RequestBody SeriesCreationRequest request) {
        return seriesUseCase.createSeries(request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping(value = "{seriesId:\\d+}")
    public SeriesResponse updateSeries(@PathVariable(name = "seriesId") Long seriesId,
                                       @Valid @RequestBody SeriesUpdateRequest request) {
        return seriesUseCase.updateSeries(seriesId, request);
    }

    @GetMapping(value = "search")
    public SeriesPageResponse searchSeries(@RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "limit", defaultValue = "10") int limit,
                                           @Valid @RequestBody SeriesFindRequest request) {
        PageFindRequest pageFindRequest = new PageFindRequest(page, limit);
        return seriesUseCase.searchSeries(request, pageFindRequest);
    }

    @Cacheable(value = "most-liked-series")
    @GetMapping(value = "most-liked")
    public SeriesPageResponse searchSeries(@RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "limit", defaultValue = "10") int limit) {
        PageFindRequest pageFindRequest = new PageFindRequest(page, limit);
        return seriesUseCase.getMostLikedSeries(pageFindRequest);
    }

    @GetMapping(value = "{seriesId:\\d+}")
    public SeriesResponse getSeriesById(@PathVariable(name = "seriesId") Long seriesId) {
        return seriesUseCase.getSeriesById(seriesId);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "{seriesId:\\d+}")
    public void removeSeries(@PathVariable(name = "seriesId") Long seriesId) {
        seriesUseCase.removeSeriesById(seriesId);
    }

    @PutMapping(value = "{seriesId:\\d+}/like")
    public void toggleLike(@PathVariable(name = "seriesId") Long seriesId) {
        seriesUseCase.toggleLike(seriesId);
    }
}
