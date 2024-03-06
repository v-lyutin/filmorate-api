package com.filmorate.filmorateapi.media.person.service;

import com.filmorate.filmorateapi.media.person.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {
    Page<Person> findPersons(Pageable pageable);

    Person getPersonById(Long personId);

    Person createPerson(Person person);

    void updatePerson(Person updatedPerson);

    void deletePerson(Long personId);

    boolean existsById(Long personId);
}
