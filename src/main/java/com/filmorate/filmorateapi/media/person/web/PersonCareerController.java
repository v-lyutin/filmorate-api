package com.filmorate.filmorateapi.media.person.web;

import com.filmorate.filmorateapi.media.person.usecase.career.PersonCareerUseCase;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonAddCareerRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "api/v1/persons")
public class PersonCareerController {
    private final PersonCareerUseCase personCareerUseCase;

    @PostMapping(value = "{personId:\\d+}/careers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPersonCareer(
            @PathVariable(name = "personId") Long personId,
            @Valid @RequestBody PersonAddCareerRequest request) {
        personCareerUseCase.addCareers(personId, request);
    }

    @DeleteMapping(value = "{personId:\\d+}/careers/{careerId:\\d+}")
    public void removePersonCareerById(
            @PathVariable(name = "personId") Long personId,
            @PathVariable(name = "careerId") Long careerId) {
        personCareerUseCase.removeCareerById(personId, careerId);
    }

    @DeleteMapping(value = "{personId:\\d+}/careers")
    public void removeAllPersonCareers(@PathVariable(name = "personId") Long personId) {
        personCareerUseCase.removeAllCareers(personId);
    }
}
