package com.filmorate.filmorateapi.media.person.service.impl;

import com.filmorate.filmorateapi.media.event.EventType;
import com.filmorate.filmorateapi.media.person.exception.PersonServiceException;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.repository.PersonRepository;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public Page<Person> findPersons(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @Override
    public Page<Person> findPersonsByEventType(Pageable pageable, EventType eventType) {
        return personRepository.findAllByEventType(pageable, eventType);
    }

    @Override
    public Person getPersonById(Long personId) {
        return personRepository
                .findById(personId)
                .orElseThrow(() -> new PersonServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Person with ID = %d not found", personId)));
    }

    @Override
    public Person getPersonByName(String name) {
        return personRepository.findByName(name)
                .orElseThrow(() -> new PersonServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Person with name '%s' not found", name)));
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person updatedPerson) {
        return personRepository.save(updatedPerson);
    }

    @Override
    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public boolean existsById(Long personId) {
        return personRepository.existsById(personId);
    }

    @Override
    public boolean existsByName(String name) {
        return personRepository.existsByName(name);
    }
}
