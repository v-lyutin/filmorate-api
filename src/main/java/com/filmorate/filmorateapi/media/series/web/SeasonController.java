package com.filmorate.filmorateapi.media.series.web;

import com.filmorate.filmorateapi.media.series.usecase.common.SeasonUseCase;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeasonCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.SeasonUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeasonCreationResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeasonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/series")
public class SeasonController {
    private final SeasonUseCase seasonUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{seriesId:\\d+}/seasons")
    public SeasonCreationResponse addSeason(@PathVariable(name = "seriesId") Long seriesId,
                                            @Valid @RequestBody SeasonCreationRequest request) {
        return seasonUseCase.createSeason(seriesId, request);
    }

    @PatchMapping(value = "seasons/{seasonId:\\d+}")
    public SeasonResponse updateSeason(@PathVariable(name = "seasonId") Long seasonId,
                                       @Valid @RequestBody SeasonUpdateRequest request) {
        return seasonUseCase.updateSeason(seasonId, request);
    }

    @GetMapping(value = "seasons/{seasonId:\\d+}")
    public SeasonResponse getSeason(@PathVariable(name = "seasonId") Long seasonId) {
        return seasonUseCase.getSeasonById(seasonId);
    }

    @GetMapping(value = "{seriesId:\\d+}/seasons")
    public List<SeasonResponse> getAllSeasons(@PathVariable(name = "seriesId") Long seriesId) {
        return seasonUseCase.getAllSeasonsBySeries(seriesId);
    }

    @DeleteMapping(value = "seasons/{seasonId:\\d+}")
    public void removeSeason(@PathVariable(name = "seasonId") Long seasonId) {
        seasonUseCase.removeSeasonById(seasonId);
    }

    @DeleteMapping(value = "{seriesId:\\d+}/seasons")
    public void removeAllSeasons(@PathVariable(name = "seriesId") Long seriesId) {
        seasonUseCase.removeAllSeasonsBySeries(seriesId);
    }
}
