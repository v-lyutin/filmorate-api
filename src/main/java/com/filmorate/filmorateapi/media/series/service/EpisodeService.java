package com.filmorate.filmorateapi.media.series.service;

import com.filmorate.filmorateapi.media.series.model.Episode;
import com.filmorate.filmorateapi.media.series.model.Season;
import java.util.List;

public interface EpisodeService {
    Episode createEpisode(Episode episode);

    Episode updateEpisode(Episode episode);

    List<Episode> getEpisodesBySeason(Season season);

    Episode getEpisodeById(Long episodeId);

    void removeEpisodeById(Long episodeId);

    Integer countEpisodesBySeason(Season season);
}
