package com.filmorate.filmorateapi.media.person.web;

import com.filmorate.filmorateapi.media.person.usecase.common.PersonCommonUseCase;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonCreationRequest;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonFindRequest;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonUpdateRequest;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonCreationResponse;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonResponse;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonsPageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/persons")
public class PersonCommonController {
    private final PersonCommonUseCase personCommonUseCase;

    @GetMapping
    public PersonsPageResponse findPersonsWithFilters(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "limit", defaultValue = "10") int limit) {
        PersonFindRequest personFindRequest = new PersonFindRequest(page, limit);
        return personCommonUseCase.findPersons(personFindRequest);
    }

    @GetMapping(value = "{personId:\\d+}")
    public PersonResponse getPersonById(@PathVariable(name = "personId") Long personId) {
        return personCommonUseCase.getPersonById(personId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PersonCreationResponse createPerson(@Valid @RequestBody PersonCreationRequest request) {
        return personCommonUseCase.createPerson(request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping(value = "{personId:\\d+}")
    public void updatePerson(@PathVariable(name = "personId") Long personId,
                             @Valid @RequestBody PersonUpdateRequest request) {
        personCommonUseCase.updatePersonById(personId, request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "{personId:\\d+}")
    public void deletePersonById(@PathVariable(name = "personId") Long personId) {
        personCommonUseCase.deletePersonById(personId);
    }
}
