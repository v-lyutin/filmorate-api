package com.filmorate.filmorateapi.media.person.service;

import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.filter.PersonFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface PersonService {

    Person createPerson(Person person);

    Person updatePerson(Person person);

    Person getPersonById(Long personId);

    Page<Person> getPersons(PersonFilter personFilter, Pageable pageable);

    void removePersonById(Long personId);

    boolean existsById(Long personId);
}
