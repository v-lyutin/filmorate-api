package com.filmorate.filmorateapi.media.content.service.impl;

import com.filmorate.filmorateapi.media.content.exception.ContentServiceException;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.model.SeriesContent;
import com.filmorate.filmorateapi.media.content.repository.SeriesContentRepository;
import com.filmorate.filmorateapi.media.content.service.SeriesContentService;
import com.filmorate.filmorateapi.media.series.model.Series;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesContentServiceImpl implements SeriesContentService {
    private final SeriesContentRepository seriesContentRepository;

    @Override
    public SeriesContent createContent(SeriesContent content) {
        return seriesContentRepository.save(content);
    }

    @Override
    public List<SeriesContent> getContentBySeries(Series series) {
        return seriesContentRepository.findAllBySeries(series);
    }

    @Override
    public List<SeriesContent> getContentBySeriesAndContentType(Series series, ContentType contentType) {
        return seriesContentRepository.findAllBySeriesAndContentType(series, contentType);
    }

    @Override
    public SeriesContent updateContent(SeriesContent content) {
        return seriesContentRepository.save(content);
    }

    @Override
    public SeriesContent getContentById(Long contentId) {
        return seriesContentRepository.findById(contentId)
                .orElseThrow(() -> new ContentServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Content with ID = '%d' not found", contentId)));
    }

    @Override
    public void removeContentById(Long contentId) {
        seriesContentRepository.deleteById(contentId);
    }

    @Override
    public void removeAllContentBySeries(Series series) {
        seriesContentRepository.removeAllBySeries(series);
    }
}
