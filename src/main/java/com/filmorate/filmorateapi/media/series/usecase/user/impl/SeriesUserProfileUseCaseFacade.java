package com.filmorate.filmorateapi.media.series.usecase.user.impl;

import com.filmorate.filmorateapi.media.series.mapper.SeriesMapper;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.service.SeriesService;
import com.filmorate.filmorateapi.media.series.usecase.user.SeriesUserProfileUseCase;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesPreviewResponse;
import com.filmorate.filmorateapi.user.api.CurrentUserProfileApiService;
import com.filmorate.filmorateapi.user.model.UserProfile;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;

@Component
@Transactional
@RequiredArgsConstructor
public class SeriesUserProfileUseCaseFacade implements SeriesUserProfileUseCase {
    private final SeriesService seriesService;
    private final SeriesMapper seriesMapper;
    private final CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public List<SeriesPreviewResponse> getFavoriteSeries() {
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();
        return userProfile.getFavoriteSeries().stream()
                .map(seriesMapper::toSeriesPreviewResponse)
                .toList();
    }

    @Override
    public void toggleFavoriteSeries(Long seriesId) {
        Series series = seriesService.getSeriesById(seriesId);
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();
        Set<Series> favouriteSeries = userProfile.getFavoriteSeries();
        if (favouriteSeries.contains(series)) {
            favouriteSeries.remove(series);
        } else {
            favouriteSeries.add(series);
        }
        currentUserProfileApiService.updateUserProfile(userProfile);
    }
}
