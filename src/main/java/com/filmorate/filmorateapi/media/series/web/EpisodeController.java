package com.filmorate.filmorateapi.media.series.web;

import com.filmorate.filmorateapi.media.series.usecase.common.EpisodeUseCase;
import com.filmorate.filmorateapi.media.series.web.dto.request.EpisodeCreationRequest;
import com.filmorate.filmorateapi.media.series.web.dto.request.EpisodeUpdateRequest;
import com.filmorate.filmorateapi.media.series.web.dto.response.EpisodePreviewResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.EpisodeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/series")
public class EpisodeController {
    private final EpisodeUseCase episodeUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("seasons/{seasonId:\\d+}/episodes")
    public EpisodeResponse addEpisode(@PathVariable(name = "seasonId") Long seasonId,
                                      @Valid @RequestBody EpisodeCreationRequest request) {
        return episodeUseCase.createEpisode(seasonId, request);
    }

    @PatchMapping("seasons/episodes/{episodeId:\\d+}")
    public EpisodeResponse updateEpisode(@PathVariable(name = "episodeId") Long episodeId,
                                         @Valid @RequestBody EpisodeUpdateRequest request) {
        return episodeUseCase.updateEpisode(episodeId, request);
    }

    @GetMapping("seasons/{seasonId:\\d+}/episodes")
    public List<EpisodePreviewResponse> getEpisodes(@PathVariable(name = "seasonId") Long seasonId) {
        return episodeUseCase.getEpisodesBySeason(seasonId);
    }

    @GetMapping("seasons/episodes/{episodeId:\\d+}")
    public EpisodeResponse getEpisode(@PathVariable(name = "episodeId") Long episodeId) {
        return episodeUseCase.getEpisodeById(episodeId);
    }

    @DeleteMapping("seasons/episodes/{episodeId:\\d+}")
    public void deleteEpisode(@PathVariable(name = "episodeId") Long episodeId) {
        episodeUseCase.removeEpisodeById(episodeId);
    }
}
