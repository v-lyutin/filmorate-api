package com.filmorate.filmorateapi.media.rating.web;

import com.filmorate.filmorateapi.media.rating.usecase.RatingUseCase;
import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingCreationRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingUpdateRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.response.RatingResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/ratings/rars")
public class RARSController {
    private final RatingUseCase ratingUseCase;

    @Autowired
    public RARSController(@Qualifier("RARSRatingUseCase") RatingUseCase ratingUseCase) {
        this.ratingUseCase = ratingUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public RatingResponse createRARS(@Valid @RequestBody RatingCreationRequest request) {
        return ratingUseCase.createRating(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping(value = "{rarsId:\\d+}")
    public RatingResponse updateRARS(@PathVariable(name = "rarsId") Long rarsId,
                                     @Valid @RequestBody RatingUpdateRequest request) {
        return ratingUseCase.updateRating(rarsId, request);
    }

    @GetMapping(value = "{rarsId:\\d+}")
    public RatingResponse getRARS(@PathVariable(name = "rarsId") Long rarsId) {
        return ratingUseCase.getRating(rarsId);
    }

    @GetMapping
    public List<RatingResponse> getAllRARSRatings() {
        return ratingUseCase.getAllRatings();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "{rarsId:\\d+}")
    public void removeRARSRating(@PathVariable(name = "rarsId") Long rarsId) {
        ratingUseCase.removeRating(rarsId);
    }
}
