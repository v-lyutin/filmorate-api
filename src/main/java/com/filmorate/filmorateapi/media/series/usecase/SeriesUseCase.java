package com.filmorate.filmorateapi.media.series.usecase;

import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesResponse;

public interface SeriesUseCase {
    SeriesResponse createSeries(SeriesCreationRequest request);

    SeriesResponse updateSeries(Long seriesId, SeriesUpdateRequest request);

    SeriesResponse getSeriesById(Long seriesId);

    void removeSeriesById(Long seriesId);
}
