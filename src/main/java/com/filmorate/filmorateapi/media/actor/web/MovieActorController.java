package com.filmorate.filmorateapi.media.actor.web;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.actor.usecase.MovieActorUseCase;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorCreationRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.request.ActorUpdateRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.response.MovieActorPageResponse;
import com.filmorate.filmorateapi.media.actor.web.dto.response.MovieActorResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "api/v1/movies")
public class MovieActorController {
    private final MovieActorUseCase movieActorUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{movieId:\\d+}/actors")
    public List<MovieActorResponse> addActors(@PathVariable(name = "movieId") Long movieId,
                                              @Valid @RequestBody List<ActorCreationRequest> request) {
        return movieActorUseCase.createActors(movieId, request);
    }

    @PatchMapping(value = "actors/{actorId:\\d+}")
    public MovieActorResponse updateActorById(@PathVariable(name = "actorId") Long actorId,
                                              @Valid @RequestBody ActorUpdateRequest request) {
        return movieActorUseCase.updateActorById(actorId, request);
    }

    @GetMapping(value = "{movieId:\\d+}/actors")
    public MovieActorPageResponse getActorsByMovie(@PathVariable(name = "movieId") Long movieId,
                                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                                   @RequestParam(name = "limit", defaultValue = "10") int limit) {
        PageFindRequest pageFindRequest = new PageFindRequest(page, limit);
        return movieActorUseCase.getActorsByMovie(movieId, pageFindRequest);
    }

    @GetMapping(value = "actors/{actorId:\\d+}")
    public MovieActorResponse getActorById(@PathVariable(name = "actorId") Long actorId) {
        return movieActorUseCase.getActorById(actorId);
    }

    @DeleteMapping(value = "actors/{actorId:\\d+}")
    public void removeActorById(@PathVariable(name = "actorId") Long actorId) {
        movieActorUseCase.removeActorById(actorId);
    }

    @DeleteMapping(value = "{movieId:\\d+}/actors")
    public void removeAllActorsByMovie(@PathVariable(name = "movieId") Long movieId) {
        movieActorUseCase.removeAllActorsByMovieId(movieId);
    }
}
