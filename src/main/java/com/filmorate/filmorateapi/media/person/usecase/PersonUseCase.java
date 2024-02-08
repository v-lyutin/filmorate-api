package com.filmorate.filmorateapi.media.person.usecase;

import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.*;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface PersonUseCase {
    PersonsPageResponse findPersons(@Valid PersonFindRequest personFindRequest);

    Person getPerson(Long personId);

    void createPerson(PersonCreationRequest personCreationRequest);

    void addImageLink(Long personId, PersonAddImageLinkRequest personAddImageLinkRequest);

    void deleteImageLink(Long personId);

    void addPersonCareers(Long personId, PersonAddCareersRequest personAddCareersRequest);

    void deletePersonCareers(Long personId);
}
