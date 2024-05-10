package com.filmorate.filmorateapi.media.series.usecase.user;

import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesPreviewResponse;
import java.util.List;

public interface SeriesUserProfileUseCase {
    List<SeriesPreviewResponse> getFavoriteSeries();

    void toggleFavoriteSeries(Long seriesId);
}
