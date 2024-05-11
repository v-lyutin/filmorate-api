package com.filmorate.filmorateapi.media.compilation.repository;

import com.filmorate.filmorateapi.media.compilation.model.Compilation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompilationRepository extends JpaRepository<Compilation, Long> {
    @Query("SELECT COUNT(l) FROM Compilation c LEFT JOIN c.likedByUsers l WHERE c.id = :id")
    Long getCompilationLikeCount(@Param("id") Long id);
}
