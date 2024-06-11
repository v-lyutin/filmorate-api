package com.filmorate.filmorateapi.media.series.service;

import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.web.dto.filter.SeriesFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SeriesService {
    Series createSeries(Series series);

    Series updateSeries(Series series);

    Series getSeriesById(Long seriesId);

    void removeSeriesById(Long seriesId);

    Page<Series> searchSeries(SeriesFilter seriesFilter, Pageable pageable);

    Page<Series> getMostLikedSeries(Pageable pageable);

    Long getSeriesLikeCount(Long seriesId);

    void toggleLike(Long seriesId);
}
