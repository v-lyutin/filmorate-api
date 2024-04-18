package com.filmorate.filmorateapi.media.series.usecase.impl;

import com.filmorate.filmorateapi.media.series.mapper.SeriesMapper;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.service.SeriesService;
import com.filmorate.filmorateapi.media.series.usecase.SeriesUseCase;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeriesUseCaseFacade implements SeriesUseCase {
    private final SeriesService seriesService;
    private final SeriesMapper seriesMapper;

    @Override
    public SeriesResponse createSeries(SeriesCreationRequest request) {
        Series series = seriesMapper.map(request);
        return seriesMapper.map(seriesService.createSeries(series));
    }

    @Override
    public SeriesResponse updateSeries(Long seriesId, SeriesUpdateRequest request) {
        Series series = seriesService.getSeriesById(seriesId);
        seriesMapper.update(request, series);
        return seriesMapper.map(seriesService.updateSeries(series));
    }

    @Override
    public SeriesResponse getSeriesById(Long seriesId) {
        return seriesMapper.map(seriesService.getSeriesById(seriesId));
    }

    @Override
    public void removeSeriesById(Long seriesId) {
        seriesService.removeSeriesById(seriesId);
    }
}
