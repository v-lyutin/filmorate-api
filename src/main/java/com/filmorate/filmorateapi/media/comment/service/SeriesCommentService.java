package com.filmorate.filmorateapi.media.comment.service;

import com.filmorate.filmorateapi.media.comment.model.SeriesComment;
import com.filmorate.filmorateapi.media.series.model.Series;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SeriesCommentService {
    Page<SeriesComment> getCommentsBySeries(Series series, Pageable pageable);

    void createSeriesComment(SeriesComment seriesComment);

    void removeAllCommentsBySeries(Series series);
}
