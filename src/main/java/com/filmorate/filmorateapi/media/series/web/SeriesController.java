package com.filmorate.filmorateapi.media.series.web;

import com.filmorate.filmorateapi.media.series.usecase.SeriesUseCase;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "{seriesId:\\d+}")
    public SeriesResponse getSeriesById(@PathVariable(name = "seriesId") Long seriesId) {
        return seriesUseCase.getSeriesById(seriesId);
    }

    @DeleteMapping(value = "{seriesId:\\d+}")
    public void removeSeries(@PathVariable(name = "seriesId") Long seriesId) {
        seriesUseCase.removeSeriesById(seriesId);
    }
}
