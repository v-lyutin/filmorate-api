package com.filmorate.filmorateapi.media.career.web;

import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.career.usecase.CareerUseCase;
import com.filmorate.filmorateapi.media.career.web.dto.CareerCreationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/careers")
public class CareerController {
    private final CareerUseCase careerUseCase;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Career> getAllCareers() {
        return careerUseCase.getAllCareers();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/{careerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Career getCareerById(@PathVariable Long careerId) {
        return careerUseCase.getCareerById(careerId);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCareer(@Valid @RequestBody CareerCreationRequest request) {
        careerUseCase.createCareer(request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/{careerId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCareer(@PathVariable Long careerId, @Valid @RequestBody CareerCreationRequest request) {
        careerUseCase.updateCareer(careerId, request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{careerId}")
    public void deleteCareer(@PathVariable Long careerId) {
        careerUseCase.deleteCareer(careerId);
    }
}
