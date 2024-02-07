package com.filmorate.filmorateapi.media.person.web;

import com.filmorate.filmorateapi.media.person.usecase.PersonUseCase;
import com.filmorate.filmorateapi.media.person.web.dto.PersonCreationRequest;
import com.filmorate.filmorateapi.media.person.web.dto.PersonFindRequest;
import com.filmorate.filmorateapi.media.person.web.dto.PersonPageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/persons")
public class PersonController {
    private final PersonUseCase personUseCase;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonPageResponse getPersons(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "limit", defaultValue = "10") int limit
    ) {
        PersonFindRequest personFindRequest = new PersonFindRequest(page, limit);
        return personUseCase.findPersons(personFindRequest);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createPerson(@Valid @RequestBody PersonCreationRequest request) {
        personUseCase.createPerson(request);
    }
}
