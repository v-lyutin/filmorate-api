package com.filmorate.filmorateapi.media.series.repository;

import com.filmorate.filmorateapi.media.series.model.Episode;
import com.filmorate.filmorateapi.media.series.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    List<Episode> findAllBySeason(Season season);

    Integer countEpisodeBySeason(Season season);
}
