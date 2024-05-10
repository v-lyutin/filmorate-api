package com.filmorate.filmorateapi.media.series.web;

import com.filmorate.filmorateapi.media.series.usecase.user.SeriesUserProfileUseCase;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesPreviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class SeriesUserProfileController {
    private final SeriesUserProfileUseCase seriesUserProfileUseCase;

    @PostMapping(value = "series/{seriesId:\\d+}/favorites")
    public void toggleFavoriteSeries(@PathVariable("seriesId") Long seriesId) {
        seriesUserProfileUseCase.toggleFavoriteSeries(seriesId);
    }

    @GetMapping(value = "profiles/myProfile/favoriteSeries")
    public List<SeriesPreviewResponse> getFavoriteSeries() {
        return seriesUserProfileUseCase.getFavoriteSeries();
    }
}
