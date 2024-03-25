package com.filmorate.filmorateapi.media.person.repository;

import com.filmorate.filmorateapi.media.event.EventType;
import com.filmorate.filmorateapi.media.person.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByName(String name);

    Page<Person> findAllByEventType(Pageable pageable, EventType eventType);

    boolean existsByName(String name);
}
