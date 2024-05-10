package com.filmorate.filmorateapi.media.series.usecase;

import com.filmorate.filmorateapi.media.series.web.dto.request.SeasonCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeasonUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeasonCreationResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeasonResponse;
import java.util.List;

public interface SeasonUseCase {
    SeasonCreationResponse createSeason(Long seriesId, SeasonCreationRequest request);

    SeasonResponse updateSeason(Long seasonId, SeasonUpdateRequest request);

    SeasonResponse getSeasonById(Long seasonId);

    List<SeasonResponse> getAllSeasonsBySeries(Long seriesId);

    void removeSeasonById(Long seasonId);

    void removeAllSeasonsBySeries(Long seriesId);
}
