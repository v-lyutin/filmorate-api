package com.filmorate.filmorateapi.media.series.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.series.mapper.EpisodeMapper;
import com.filmorate.filmorateapi.media.series.mapper.SeasonMapper;
import com.filmorate.filmorateapi.media.series.model.Season;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.service.EpisodeService;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeasonCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeasonUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.EpisodePreviewResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeasonCreationResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeasonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SeasonMapperImpl implements SeasonMapper {
    private final EpisodeMapper episodeMapper;
    private final EpisodeService episodeService;
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public Season toSeason(Series series, SeasonCreationRequest request) {
        return Season.builder()
                .posterUrl(request.posterUrl())
                .seasonNumber(request.seasonNumber())
                .series(series)
                .build();
    }

    @Override
    public SeasonResponse toSeasonResponse(Season season) {
        List<EpisodePreviewResponse> episodes = episodeService.getEpisodesBySeason(season).stream()
                .map(episode -> episodeMapper.toPreview(episode, season))
                .toList();
        return new SeasonResponse(
                season.getId(),
                season.getPosterUrl(),
                season.getSeasonNumber(),
                episodeService.countEpisodesBySeason(season),
                episodes
        );
    }

    @Override
    public SeasonCreationResponse toSeasonCreationResponse(Season season) {
        return new SeasonCreationResponse(season.getId(), season.getPosterUrl(), season.getSeasonNumber());
    }

    @Override
    public void update(Season season, SeasonUpdateRequest request) {
        if (request == null) {
            return;
        }
        if (jsonNullableMapper.isPresent(request.posterUrl())) {
            season.setPosterUrl(jsonNullableMapper.unwrap(request.posterUrl()));
        }
        if (jsonNullableMapper.isPresent(request.seasonNumber())) {
            season.setSeasonNumber(jsonNullableMapper.unwrap(request.seasonNumber()));
        }
    }
}
