package com.filmorate.filmorateapi.media.series.usecase.common.impl;

import com.filmorate.filmorateapi.media.series.mapper.EpisodeMapper;
import com.filmorate.filmorateapi.media.series.model.Episode;
import com.filmorate.filmorateapi.media.series.model.Season;
import com.filmorate.filmorateapi.media.series.service.EpisodeService;
import com.filmorate.filmorateapi.media.series.service.SeasonService;
import com.filmorate.filmorateapi.media.series.usecase.common.EpisodeUseCase;
import com.filmorate.filmorateapi.media.series.web.dto.request.EpisodeCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.EpisodeUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.EpisodePreviewResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.EpisodeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EpisodeUseCaseFacade implements EpisodeUseCase {
    private final EpisodeService episodeService;
    private final SeasonService seasonService;
    private final EpisodeMapper episodeMapper;

    @Override
    public EpisodeResponse createEpisode(Long seasonId, EpisodeCreationRequest request) {
        Season season = seasonService.getSeasonById(seasonId);
        Episode episode = episodeMapper.map(season, request);
        return episodeMapper.map(episodeService.createEpisode(episode));
    }

    @Override
    public EpisodeResponse updateEpisode(Long episodeId, EpisodeUpdateRequest request) {
        Episode episode = episodeService.getEpisodeById(episodeId);
        episodeMapper.update(episode, request);
        return episodeMapper.map(episodeService.updateEpisode(episode));
    }

    @Override
    public EpisodeResponse getEpisodeById(Long episodeId) {
        return episodeMapper.map(episodeService.getEpisodeById(episodeId));
    }

    @Override
    public List<EpisodePreviewResponse> getEpisodesBySeason(Long seasonId) {
        Season season = seasonService.getSeasonById(seasonId);
        List<Episode> episodes = episodeService.getEpisodesBySeason(season);
        return episodes.stream()
                .map(episode -> episodeMapper.toPreview(episode, season))
                .collect(Collectors.toList());
    }

    @Override
    public void removeEpisodeById(Long episodeId) {
        episodeService.removeEpisodeById(episodeId);
    }
}
