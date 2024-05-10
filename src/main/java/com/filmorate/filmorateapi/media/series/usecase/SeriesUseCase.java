package com.filmorate.filmorateapi.media.series.usecase;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.series.web.dto.filter.SeriesFilter;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesFindRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesPageResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface SeriesUseCase {
    SeriesResponse createSeries(SeriesCreationRequest request);

    SeriesResponse updateSeries(Long seriesId, SeriesUpdateRequest request);

    SeriesResponse getSeriesById(Long seriesId);

    void removeSeriesById(Long seriesId);

    SeriesPageResponse getSeriesWithFilters(SeriesFindRequest seriesFindRequest, @Valid PageFindRequest pageFindRequest);

    void toggleLike(Long seriesId);
}
