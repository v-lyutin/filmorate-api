package com.filmorate.filmorateapi.media.actor.web;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.actor.usecase.SeriesActorUseCase;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorCreationRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorUpdateRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.response.SeriesActorPageResponse;
import com.filmorate.filmorateapi.media.actor.web.dto.response.SeriesActorResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "api/v1/series")
public class SeriesActorController {
    private final SeriesActorUseCase seriesActorUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{seriesId:\\d+}/actors")
    public List<SeriesActorResponse> addActors(@PathVariable(name = "seriesId") Long seriesId,
                                               @Valid @RequestBody List<ActorCreationRequest> request) {
        return seriesActorUseCase.createActors(seriesId, request);
    }

    @PatchMapping(value = "actors/{actorId:\\d+}")
    public SeriesActorResponse updateActorById(@PathVariable(name = "actorId") Long actorId,
                                               @Valid @RequestBody ActorUpdateRequest request) {
        return seriesActorUseCase.updateActorById(actorId, request);
    }

    @GetMapping(value = "{seriesId:\\d+}/actors")
    public SeriesActorPageResponse getActorsByMovie(@PathVariable(name = "seriesId") Long seriesId,
                                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                                    @RequestParam(name = "limit", defaultValue = "10") int limit) {
        PageFindRequest pageFindRequest = new PageFindRequest(page, limit);
        return seriesActorUseCase.getActorsBySeries(seriesId, pageFindRequest);
    }

    @GetMapping(value = "actors/{actorId:\\d+}")
    public SeriesActorResponse getActorById(@PathVariable(name = "actorId") Long actorId) {
        return seriesActorUseCase.getActorById(actorId);
    }

    @DeleteMapping(value = "actors/{actorId:\\d+}")
    public void removeActorById(@PathVariable(name = "actorId") Long actorId) {
        seriesActorUseCase.removeActorById(actorId);
    }

    @DeleteMapping(value = "{seriesId:\\d+}/actors")
    public void removeAllActorsByMovie(@PathVariable(name = "seriesId") Long seriesId) {
        seriesActorUseCase.removeAllActorsByMovieId(seriesId);
    }
}
