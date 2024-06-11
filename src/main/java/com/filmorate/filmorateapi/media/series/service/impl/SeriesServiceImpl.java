package com.filmorate.filmorateapi.media.series.service.impl;

import com.filmorate.filmorateapi.media.series.exception.SeriesServiceException;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.repository.SeriesRepository;
import com.filmorate.filmorateapi.media.series.service.SeriesService;
import com.filmorate.filmorateapi.media.series.web.dto.filter.SeriesFilter;
import com.filmorate.filmorateapi.user.api.CurrentUserProfileApiService;
import com.filmorate.filmorateapi.user.model.UserProfile;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SeriesServiceImpl implements SeriesService {
    private final SeriesRepository seriesRepository;
    private final CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public Series createSeries(Series series) {
        return seriesRepository.save(series);
    }

    @Override
    public Series updateSeries(Series series) {
        return seriesRepository.save(series);
    }

    @Override
    public Series getSeriesById(Long seriesId) {
        return seriesRepository.findById(seriesId)
                .orElseThrow(() -> new SeriesServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Series with ID = '%d' not found", seriesId)));
    }

    @Override
    public void removeSeriesById(Long seriesId) {
        seriesRepository.deleteById(seriesId);
    }

    @Override
    public Page<Series> searchSeries(SeriesFilter seriesFilter, Pageable pageable) {
        return seriesRepository.findAll(seriesFilter, pageable);
    }

    @Override
    public Page<Series> getMostLikedSeries(Pageable pageable) {
        return seriesRepository.findAllOrderByLikes(pageable);
    }

    @Override
    public Long getSeriesLikeCount(Long seriesId) {
        return seriesRepository.getSeriesLikeCount(seriesId);
    }

    @Override
    @Transactional
    public void toggleLike(Long seriesId) {
        Series series = getSeriesById(seriesId);
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();
        Set<UserProfile> likes = series.getLikedByUsers();
        if (likes.contains(userProfile)) {
            likes.remove(userProfile);
        } else {
            likes.add(userProfile);
        }
        seriesRepository.save(series);
    }
}
