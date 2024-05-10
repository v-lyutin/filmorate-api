package com.filmorate.filmorateapi.media.series.usecase.common.impl;

import com.filmorate.filmorateapi.media.series.mapper.SeasonMapper;
import com.filmorate.filmorateapi.media.series.model.Season;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.service.SeasonService;
import com.filmorate.filmorateapi.media.series.service.SeriesService;
import com.filmorate.filmorateapi.media.series.usecase.common.SeasonUseCase;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeasonCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeasonUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeasonCreationResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeasonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SeasonUseCaseFacade implements SeasonUseCase {
    private final SeasonService seasonService;
    private final SeriesService seriesService;
    private final SeasonMapper seasonMapper;

    @Override
    public SeasonCreationResponse createSeason(Long seriesId, SeasonCreationRequest request) {
        Series series = seriesService.getSeriesById(seriesId);
        Season season = seasonMapper.toSeason(series, request);
        return seasonMapper.toSeasonCreationResponse(seasonService.createSeason(season));
    }

    @Override
    public SeasonResponse updateSeason(Long seasonId, SeasonUpdateRequest request) {
        Season season = seasonService.getSeasonById(seasonId);
        seasonMapper.update(season, request);
        return seasonMapper.toSeasonResponse(seasonService.updateSeason(season));
    }

    @Override
    public SeasonResponse getSeasonById(Long seasonId) {
        return seasonMapper.toSeasonResponse(seasonService.getSeasonById(seasonId));
    }

    @Override
    public List<SeasonResponse> getAllSeasonsBySeries(Long seriesId) {
        Series series = seriesService.getSeriesById(seriesId);
        return seasonService.getAllSeasonsBySeries(series).stream()
                .map(seasonMapper::toSeasonResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void removeSeasonById(Long seasonId) {
        seasonService.removeSeasonById(seasonId);
    }

    @Override
    public void removeAllSeasonsBySeries(Long seriesId) {
        Series series = seriesService.getSeriesById(seriesId);
        seasonService.removeAllSeasonsBySeries(series);
    }
}
