package com.filmorate.filmorateapi.media.series.service;

import com.filmorate.filmorateapi.media.series.model.Series;

public interface SeriesService {
    Series createSeries(Series series);

    Series updateSeries(Series series);

    Series getSeriesById(Long seriesId);

    void removeSeriesById(Long seriesId);
}
