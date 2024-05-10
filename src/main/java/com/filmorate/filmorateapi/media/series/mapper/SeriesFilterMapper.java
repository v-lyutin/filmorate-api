package com.filmorate.filmorateapi.media.series.mapper;

import com.filmorate.filmorateapi.media.series.web.dto.filter.SeriesFilter;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeriesFindRequest;

public interface SeriesFilterMapper {
    SeriesFilter map(SeriesFindRequest request);
}
