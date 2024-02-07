package com.filmorate.filmorateapi.media.person.usecase;

import com.filmorate.filmorateapi.media.person.web.dto.PersonCreationRequest;
import com.filmorate.filmorateapi.media.person.web.dto.PersonFindRequest;
import com.filmorate.filmorateapi.media.person.web.dto.PersonPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface PersonUseCase {
    PersonPageResponse findPersons(@Valid PersonFindRequest personFindRequest);

    void createPerson(PersonCreationRequest personCreationRequest);
}
