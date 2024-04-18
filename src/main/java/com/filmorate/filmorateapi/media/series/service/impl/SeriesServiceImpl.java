package com.filmorate.filmorateapi.media.series.service.impl;

import com.filmorate.filmorateapi.media.series.exception.SeriesServiceException;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.repository.SeriesRepository;
import com.filmorate.filmorateapi.media.series.service.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeriesServiceImpl implements SeriesService {
    private final SeriesRepository seriesRepository;

    @Override
    public Series createSeries(Series series) {
        return seriesRepository.save(series);
    }

    @Override
    public Series updateSeries(Series series) {
        return seriesRepository.save(series);
    }

    @Override
    public Series getSeriesById(Long seriesId) {
        return seriesRepository.findById(seriesId)
                .orElseThrow(() -> new SeriesServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Series with ID = '%d' not found", seriesId)));
    }

    @Override
    public void removeSeriesById(Long seriesId) {
        seriesRepository.deleteById(seriesId);
    }
}
