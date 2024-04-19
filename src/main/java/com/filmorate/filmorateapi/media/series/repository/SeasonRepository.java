package com.filmorate.filmorateapi.media.series.repository;

import com.filmorate.filmorateapi.media.series.model.Season;
import com.filmorate.filmorateapi.media.series.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
    List<Season> findAllBySeries(Series series);

    Integer countSeasonsBySeries(Series series);

    void deleteAllBySeries(Series series);
}
