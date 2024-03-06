package com.filmorate.filmorateapi.media.person.service.impl;

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
    public Person getPersonById(Long personId) {
        return personRepository
                .findById(personId)
                .orElseThrow(() -> new PersonServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Person with ID = %d not found", personId)));
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void updatePerson(Person updatedPerson) {
        personRepository.save(updatedPerson);
    }

    @Override
    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public boolean existsById(Long personId) {
        return personRepository.existsById(personId);
    }
}
