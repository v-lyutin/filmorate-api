package com.filmorate.filmorateapi.media.series.service;

import com.filmorate.filmorateapi.media.series.model.Season;
import com.filmorate.filmorateapi.media.series.model.Series;
import java.util.List;

public interface SeasonService {
    Season createSeason(Season season);

    Season updateSeason(Season season);

    Season getSeasonById(Long seasonId);

    List<Season> getAllSeasonsBySeries(Series series);

    void removeSeasonById(Long seasonId);

    void removeAllSeasonsBySeries(Series series);

    Integer countSeasonsBySeries(Series series);
}
