package com.filmorate.filmorateapi.media.comment.repository;

import com.filmorate.filmorateapi.media.comment.model.SeriesComment;
import com.filmorate.filmorateapi.media.series.model.Series;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesCommentRepository extends JpaRepository<SeriesComment, Long> {
    Page<SeriesComment> findAllBySeries(Series series, Pageable pageable);

    void removeAllBySeries(Series series);
}
