package com.filmorate.filmorateapi.media.person.usecase;

import com.filmorate.filmorateapi.media.person.web.dto.*;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface PersonUseCase {
    PersonPageResponse findPersons(@Valid PersonFindRequest personFindRequest);

    void createPerson(PersonCreationRequest personCreationRequest);

    void addImageLink(Long personId, PersonAddImageLinkRequest personAddImageLinkRequest);

    void deleteImageLink(Long personId);

    void addPersonCareers(Long personId, PersonAddCareersRequest personAddCareersRequest);

    void deletePersonCareers(Long personId);
}
