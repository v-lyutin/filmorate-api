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
@RequestMapping(value = "api/v1/ratings/mpaa")
public class MPAAController {
    private final RatingUseCase ratingUseCase;

    @Autowired
    public MPAAController(@Qualifier("MPAARatingUseCase") RatingUseCase ratingUseCase) {
        this.ratingUseCase = ratingUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public RatingResponse createRARSRating(@Valid @RequestBody RatingCreationRequest request) {
        return ratingUseCase.createRating(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping(value = "{mpaaId:\\d+}")
    public RatingResponse updateRARSRating(@PathVariable(name = "mpaaId") Long mpaaId,
                                           @Valid @RequestBody RatingUpdateRequest request) {
        return ratingUseCase.updateRating(mpaaId, request);
    }

    @GetMapping(value = "{mpaaId:\\d+}")
    public RatingResponse getMPAARating(@PathVariable(name = "mpaaId") Long mpaaId) {
        return ratingUseCase.getRating(mpaaId);
    }

    @GetMapping
    public List<RatingResponse> getAllRARSRatings() {
        return ratingUseCase.getAllRatings();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "{mpaaId:\\d+}")
    public void removeRARSRating(@PathVariable(name = "mpaaId") Long mpaaId) {
        ratingUseCase.removeRating(mpaaId);
    }
}
