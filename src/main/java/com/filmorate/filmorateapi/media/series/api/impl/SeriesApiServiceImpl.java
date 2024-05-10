package com.filmorate.filmorateapi.media.series.api.impl;

import com.filmorate.filmorateapi.media.series.api.SeriesApiService;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.service.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeriesApiServiceImpl implements SeriesApiService {
    private final SeriesService seriesService;

    @Override
    public Series getSeriesById(Long seriesId) {
        return seriesService.getSeriesById(seriesId);
    }
}
