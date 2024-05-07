package com.filmorate.filmorateapi.media.person.web;

import com.filmorate.filmorateapi.media.person.usecase.common.PersonUseCase;
import com.filmorate.filmorateapi.media.person.web.dto.filter.PersonFilter;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonCreationRequest;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonFindRequest;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonUpdateRequest;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonResponse;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonsPageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/persons")
public class PersonController {
    private final PersonUseCase personCommonUseCase;

    @GetMapping(value = "search")
    public PersonsPageResponse getAllPersons(@RequestParam(name = "page", defaultValue = "0") int page,
                                             @RequestParam(name = "limit", defaultValue = "10") int limit,
                                             @RequestParam(name = "name", required = false) String name,
                                             @RequestParam(name = "enName", required = false) String enName,
                                             @RequestParam(name = "countryOfBirth", required = false) String countryOfBirth,
                                             @RequestParam(name = "cityOfBirth", required = false) String cityOfBirth,
                                             @RequestParam(name = "height", required = false) String height,
                                             @RequestParam(name = "careers", required = false) Set<String> careers) {
        PersonFilter personFilter = PersonFilter.builder()
                .name(name)
                .enName(enName)
                .cityOfBirth(cityOfBirth)
                .countryOfBirth(countryOfBirth)
                .height(height)
                .careers(careers)
                .build();
        PersonFindRequest personFindRequest = new PersonFindRequest(page, limit);
        return personCommonUseCase.getPersonsWithFilters(personFilter, personFindRequest);
    }

    @GetMapping(value = "{personId:\\d+}")
    public PersonResponse getPersonById(@PathVariable(name = "personId") Long personId) {
        return personCommonUseCase.getPersonById(personId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PersonResponse addPerson(@Valid @RequestBody PersonCreationRequest request) {
        return personCommonUseCase.createPerson(request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping(value = "{personId:\\d+}")
    public PersonResponse updatePerson(@PathVariable(name = "personId") Long personId,
                                       @Valid @RequestBody PersonUpdateRequest request) {
        return personCommonUseCase.updatePerson(personId, request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "{personId:\\d+}")
    public void deletePersonById(@PathVariable(name = "personId") Long personId) {
        personCommonUseCase.removePersonById(personId);
    }
}
