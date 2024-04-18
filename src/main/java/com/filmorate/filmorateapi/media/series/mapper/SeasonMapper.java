package com.filmorate.filmorateapi.media.series.mapper;

import com.filmorate.filmorateapi.media.series.model.Season;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeasonCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeasonUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeasonCreationResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeasonResponse;

public interface SeasonMapper {
    Season toSeason(Series series, SeasonCreationRequest request);

    SeasonResponse toSeasonResponse(Season season);

    SeasonCreationResponse toSeasonCreationResponse(Season season);

    void update(Season season, SeasonUpdateRequest request);
}
