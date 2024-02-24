package com.filmorate.filmorateapi.media.fact.repository;

import com.filmorate.filmorateapi.media.fact.model.Fact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactRepository extends JpaRepository<Fact, Long> {
}
