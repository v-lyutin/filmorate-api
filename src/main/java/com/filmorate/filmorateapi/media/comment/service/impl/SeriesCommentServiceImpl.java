package com.filmorate.filmorateapi.media.comment.service.impl;

import com.filmorate.filmorateapi.media.comment.model.SeriesComment;
import com.filmorate.filmorateapi.media.comment.repository.SeriesCommentRepository;
import com.filmorate.filmorateapi.media.comment.service.SeriesCommentService;
import com.filmorate.filmorateapi.media.series.model.Series;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeriesCommentServiceImpl implements SeriesCommentService {
    private final SeriesCommentRepository seriesCommentRepository;

    @Override
    public Page<SeriesComment> getCommentsBySeries(Series series, Pageable pageable) {
        return seriesCommentRepository.findAllBySeries(series, pageable);
    }

    @Override
    public void createSeriesComment(SeriesComment seriesComment) {
        seriesCommentRepository.save(seriesComment);
    }

    @Override
    public void removeAllCommentsBySeries(Series series) {
        seriesCommentRepository.removeAllBySeries(series);
    }
}
