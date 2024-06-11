package com.filmorate.filmorateapi.media.person.repository;

import com.filmorate.filmorateapi.media.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>,
        JpaSpecificationExecutor<Person> {
}
