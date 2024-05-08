package com.filmorate.filmorateapi.media.series.web;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.series.usecase.SeriesUseCase;
import com.filmorate.filmorateapi.media.series.web.dto.filter.SeriesFilter;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesPageResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/series")
public class SeriesController {
    private final SeriesUseCase seriesUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SeriesResponse addSeries(@Valid @RequestBody SeriesCreationRequest request) {
        return seriesUseCase.createSeries(request);
    }

    @PatchMapping(value = "{seriesId:\\d+}")
    public SeriesResponse updateSeries(@PathVariable(name = "seriesId") Long seriesId,
                                       @Valid @RequestBody SeriesUpdateRequest request) {
        return seriesUseCase.updateSeries(seriesId, request);
    }

    @GetMapping(value = "search")
    public SeriesPageResponse getSeries(@RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "limit", defaultValue = "10") int limit,
                                        @RequestParam(name = "title", required = false) String title,
                                        @RequestParam(name = "originalTitle", required = false) String originalTitle,
                                        @RequestParam(name = "releaseYear", required = false) String releaseYear,
                                        @RequestParam(name = "country", required = false) String country,
                                        @RequestParam(name = "isFinished", required = false) String isFinished,
                                        @RequestParam(name = "genre", required = false) Set<String> genres) {
        SeriesFilter seriesFilter = SeriesFilter.builder()
                .title(title)
                .originalTitle(originalTitle)
                .releaseYear(releaseYear)
                .country(country)
                .isFinished(isFinished)
                .genres(genres)
                .build();
        PageFindRequest pageFindRequest = new PageFindRequest(page, limit);
        return seriesUseCase.getSeriesWithFilters(seriesFilter, pageFindRequest);
    }

    @GetMapping(value = "{seriesId:\\d+}")
    public SeriesResponse getSeriesById(@PathVariable(name = "seriesId") Long seriesId) {
        return seriesUseCase.getSeriesById(seriesId);
    }

    @DeleteMapping(value = "{seriesId:\\d+}")
    public void removeSeries(@PathVariable(name = "seriesId") Long seriesId) {
        seriesUseCase.removeSeriesById(seriesId);
    }

    @PutMapping(value = "{seriesId:\\d+}/like")
    public void toggleLike(@PathVariable(name = "seriesId") Long seriesId) {
        seriesUseCase.toggleLike(seriesId);
    }
}
