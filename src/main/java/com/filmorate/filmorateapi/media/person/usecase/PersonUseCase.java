package com.filmorate.filmorateapi.media.person.usecase;

import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.*;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonUpdateInfoRequest;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface PersonUseCase {
    PersonsPageResponse findPersons(@Valid PersonFindRequest personFindRequest);

    Person getPerson(Long personId);

    void createPerson(PersonCreationRequest personCreationRequest);

    void updatePerson(Long personId, PersonUpdateInfoRequest personUpdateInfoRequest);

    void addImageLink(Long personId, PersonAddImageLinkRequest personAddImageLinkRequest);

    void deleteImageLink(Long personId);

    void addPersonCareers(Long personId, PersonAddCareersRequest personAddCareersRequest);

    void deletePersonCareers(Long personId);
}
