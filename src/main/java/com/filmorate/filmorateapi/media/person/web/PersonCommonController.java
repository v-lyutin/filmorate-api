package com.filmorate.filmorateapi.media.person.web;

import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.usecase.common.PersonCommonUseCase;
import com.filmorate.filmorateapi.media.person.web.dto.request.*;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonsPageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/persons")
public class PersonCommonController {
    private final PersonCommonUseCase personCommonUseCase;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonsPageResponse getPersons(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "limit", defaultValue = "10") int limit
    ) {
        PersonFindRequest personFindRequest = new PersonFindRequest(page, limit);
        return personCommonUseCase.findPersons(personFindRequest);
    }

    @GetMapping(value = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPersonById(@PathVariable(name = "personId") Long personId) {
        return personCommonUseCase.getPersonById(personId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createPerson(@Valid @RequestBody PersonCreationRequest request) {
        personCommonUseCase.createPerson(request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping(value = "/{personId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePerson(@PathVariable(name = "personId") Long personId,
                             @Valid @RequestBody PersonUpdateRequest request) {
        personCommonUseCase.updatePersonById(personId, request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{personId}")
    public void deletePersonById(@PathVariable(name = "personId") Long personId) {
        personCommonUseCase.deletePersonById(personId);
    }
}
