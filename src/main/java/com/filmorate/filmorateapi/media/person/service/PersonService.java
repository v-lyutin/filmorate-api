package com.filmorate.filmorateapi.media.person.service;

import com.filmorate.filmorateapi.media.person.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {

    Person createPerson(Person person);

    Person updatePerson(Person person);

    Person getPersonById(Long personId);

    Page<Person> getAllPersons(Pageable pageable);

    void removePersonById(Long personId);
}
