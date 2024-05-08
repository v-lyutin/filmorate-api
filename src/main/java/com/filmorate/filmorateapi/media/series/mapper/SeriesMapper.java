package com.filmorate.filmorateapi.media.series.mapper;

import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesPageResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesResponse;
import org.springframework.data.domain.Page;

public interface SeriesMapper {
    Series map(SeriesCreationRequest request);

    SeriesResponse map(Series series);

    void update(SeriesUpdateRequest request, Series series);

    SeriesPageResponse toSeriesPageResponse(Page<Series> series);
}
