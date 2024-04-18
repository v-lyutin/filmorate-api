package com.filmorate.filmorateapi.media.series.service.impl;

import com.filmorate.filmorateapi.media.series.exception.SeasonServiceException;
import com.filmorate.filmorateapi.media.series.model.Season;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.repository.SeasonRepository;
import com.filmorate.filmorateapi.media.series.service.SeasonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SeasonServiceImpl implements SeasonService {
    private final SeasonRepository seasonRepository;

    @Override
    public Season createSeason(Season season) {
        return seasonRepository.save(season);
    }

    @Override
    public Season updateSeason(Season season) {
        return seasonRepository.save(season);
    }

    @Override
    public Season getSeasonById(Long seasonId) {
        return seasonRepository.findById(seasonId)
                .orElseThrow(() -> new SeasonServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Season with ID = '%d' not found", seasonId)));
    }

    @Override
    public List<Season> getAllSeasonsBySeries(Series series) {
        return seasonRepository.findAllBySeries(series);
    }

    @Override
    public void removeSeasonById(Long seasonId) {
        seasonRepository.deleteById(seasonId);
    }

    @Override
    public void removeAllSeasonsBySeries(Series series) {
        seasonRepository.deleteAllBySeries(series);
    }

    @Override
    public Integer countSeasonsBySeries(Series series) {
        return seasonRepository.countSeasonsBySeries(series);
    }
}
