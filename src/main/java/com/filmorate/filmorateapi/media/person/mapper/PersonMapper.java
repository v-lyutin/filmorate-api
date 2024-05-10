package com.filmorate.filmorateapi.media.person.mapper;

import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonCreationRequest;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonUpdateRequest;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonPreviewResponse;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonResponse;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonsPageResponse;
import org.springframework.data.domain.Page;

public interface PersonMapper {
    Person toPerson(PersonCreationRequest request);

    PersonResponse toPersonResponse(Person person);

    PersonsPageResponse toPersonsPageResponse(Page<Person> pageablePersons);

    PersonPreviewResponse toPersonPreviewResponse(Person person);

    void update(PersonUpdateRequest request, Person person);
}
