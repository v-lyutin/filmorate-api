package com.filmorate.filmorateapi.media.person.service;

import com.filmorate.filmorateapi.media.event.EventType;
import com.filmorate.filmorateapi.media.person.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {
    Page<Person> findPersons(Pageable pageable);

    Page<Person> findPersonsByEventType(Pageable pageable, EventType eventType);

    Person getPersonById(Long personId);

    Person getPersonByName(String name);

    Person createPerson(Person person);

    Person updatePerson(Person updatedPerson);

    void deletePerson(Long personId);

    boolean existsById(Long personId);

    boolean existsByName(String name);
}
