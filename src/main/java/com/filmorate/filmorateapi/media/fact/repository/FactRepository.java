package com.filmorate.filmorateapi.media.fact.repository;

import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FactRepository extends JpaRepository<Fact, Long> {
    List<Fact> findFactsByPerson(Person person);
}
