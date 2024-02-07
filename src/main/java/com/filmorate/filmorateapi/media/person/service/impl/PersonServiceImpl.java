package com.filmorate.filmorateapi.media.person.service.impl;

import com.filmorate.filmorateapi.media.person.exception.PersonServiceException;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.repository.PersonRepository;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
                .orElseThrow(() -> new PersonServiceException(String.format("Личность с ID = %d не найдена", personId)));
    }

    @Override
    public void createPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void updatePerson(Person updatedPerson) {
        personRepository.save(updatedPerson);
    }

    @Override
    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }
}
