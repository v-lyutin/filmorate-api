package com.filmorate.filmorateapi.media.career.web;

import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.career.usecase.CareerUseCase;
import com.filmorate.filmorateapi.media.career.web.dto.CareerCreationRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "api/v1/careers")
public class CareerController {
    private final CareerUseCase careerUseCase;

    @GetMapping
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public Collection<Career> getAllCareers() {
        return careerUseCase.getAllCareers();
    }

    @GetMapping(value = "{careerId:\\d+}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public Career getCareerById(@PathVariable Long careerId) {
        return careerUseCase.getCareerById(careerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public void createCareer(@Valid @RequestBody CareerCreationRequest request) {
        careerUseCase.createCareer(request);
    }

    @PutMapping(value = "{careerId:\\d+}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public void updateCareer(@PathVariable Long careerId, @Valid @RequestBody CareerCreationRequest request) {
        careerUseCase.updateCareer(careerId, request);
    }

    @DeleteMapping(value = "{careerId:\\d+}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public void deleteCareer(@PathVariable Long careerId) {
        careerUseCase.deleteCareer(careerId);
    }
}
