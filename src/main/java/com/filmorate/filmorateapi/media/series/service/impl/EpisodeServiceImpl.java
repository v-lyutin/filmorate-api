package com.filmorate.filmorateapi.media.series.service.impl;

import com.filmorate.filmorateapi.media.series.exception.EpisodeServiceException;
import com.filmorate.filmorateapi.media.series.model.Episode;
import com.filmorate.filmorateapi.media.series.model.Season;
import com.filmorate.filmorateapi.media.series.repository.EpisodeRepository;
import com.filmorate.filmorateapi.media.series.service.EpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl implements EpisodeService {
    private final EpisodeRepository episodeRepository;

    @Override
    public Episode createEpisode(Episode episode) {
        return episodeRepository.save(episode);
    }

    @Override
    public Episode updateEpisode(Episode episode) {
        return episodeRepository.save(episode);
    }

    @Override
    public List<Episode> getEpisodesBySeason(Season season) {
        return episodeRepository.findAllBySeason(season);
    }

    @Override
    public Episode getEpisodeById(Long episodeId) {
        return episodeRepository.findById(episodeId)
                .orElseThrow(() -> new EpisodeServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Episode with ID = '%d' not found", episodeId)));
    }

    @Override
    public void removeEpisodeById(Long episodeId) {
        episodeRepository.deleteById(episodeId);
    }

    @Override
    public Integer countEpisodesBySeason(Season season) {
        return episodeRepository.countEpisodeBySeason(season);
    }
}
