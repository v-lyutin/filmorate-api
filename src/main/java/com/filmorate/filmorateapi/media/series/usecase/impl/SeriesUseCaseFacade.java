package com.filmorate.filmorateapi.media.series.usecase.impl;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.series.mapper.SeriesFilterMapper;
import com.filmorate.filmorateapi.media.series.mapper.SeriesMapper;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.service.SeriesService;
import com.filmorate.filmorateapi.media.series.usecase.SeriesUseCase;
import com.filmorate.filmorateapi.media.series.web.dto.filter.SeriesFilter;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesFindRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesPageResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeriesUseCaseFacade implements SeriesUseCase {
    private final SeriesService seriesService;
    private final SeriesMapper seriesMapper;
    private final SeriesFilterMapper seriesFilterMapper;

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

    @Override
    public SeriesPageResponse searchSeries(SeriesFindRequest seriesFindRequest, PageFindRequest pageFindRequest) {
        Pageable pageable = PageRequest.of(pageFindRequest.page(), pageFindRequest.limit());
        SeriesFilter seriesFilter = seriesFilterMapper.map(seriesFindRequest);
        Page<Series> series = seriesService.searchSeries(seriesFilter, pageable);
        return seriesMapper.toSeriesPageResponse(series);
    }

    @Override
    public SeriesPageResponse getMostLikedSeries(PageFindRequest pageFindRequest) {
        Pageable pageable = PageRequest.of(pageFindRequest.page(), pageFindRequest.limit());
        Page<Series> series = seriesService.getMostLikedSeries(pageable);
        return seriesMapper.toSeriesPageResponse(series);
    }

    @Override
    public void toggleLike(Long seriesId) {
        seriesService.toggleLike(seriesId);
    }
}
