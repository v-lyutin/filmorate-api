package com.filmorate.filmorateapi.media.series.api;

import com.filmorate.filmorateapi.media.series.model.Series;

public interface SeriesApiService {
    Series getSeriesById(Long seriesId);
}
