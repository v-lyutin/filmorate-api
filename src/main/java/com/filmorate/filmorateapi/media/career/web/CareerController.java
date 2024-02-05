package com.filmorate.filmorateapi.media.career.web;

import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.career.usecase.CareerUseCase;
import com.filmorate.filmorateapi.media.career.web.dto.CareerCreationRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "/api/v1/careers")
public class CareerController {
    private final CareerUseCase careerUseCase;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public Collection<Career> getAllCareers() {
        return careerUseCase.getAllCareers();
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @GetMapping(value = "/{careerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Career getCareerById(@PathVariable Long careerId) {
        return careerUseCase.getCareerById(careerId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCareer(@Valid @RequestBody CareerCreationRequest request) {
        careerUseCase.createCareer(request);
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @PutMapping(value = "/{careerId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCareer(@PathVariable Long careerId, @Valid @RequestBody CareerCreationRequest request) {
        careerUseCase.updateCareer(careerId, request);
    }

    @DeleteMapping(value = "/{careerId}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public void deleteCareer(@PathVariable Long careerId) {
        careerUseCase.deleteCareer(careerId);
    }
}
