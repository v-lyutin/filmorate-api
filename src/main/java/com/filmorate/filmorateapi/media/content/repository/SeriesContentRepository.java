package com.filmorate.filmorateapi.media.content.repository;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.model.SeriesContent;
import com.filmorate.filmorateapi.media.series.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SeriesContentRepository extends JpaRepository<SeriesContent, Long> {
    List<SeriesContent> findAllBySeries(Series series);

    List<SeriesContent> findAllBySeriesAndContentType(Series series, ContentType contentType);

    void removeAllBySeries(Series series);
}
