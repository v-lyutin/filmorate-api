package com.filmorate.filmorateapi.media.content.usecase.impl;

import com.filmorate.filmorateapi.media.content.mapper.SeriesContentMapper;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.model.SeriesContent;
import com.filmorate.filmorateapi.media.content.service.SeriesContentService;
import com.filmorate.filmorateapi.media.content.usecase.SeriesContentUseCase;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.SeriesContentResponse;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.service.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SeriesContentUseCaseFacade implements SeriesContentUseCase {
    private final SeriesService seriesService;
    private final SeriesContentService seriesContentService;
    private final SeriesContentMapper seriesContentMapper;

    @Override
    public SeriesContentResponse createContent(Long seriesId, ContentRequest request, ContentType contentType) {
        Series series = seriesService.getSeriesById(seriesId);
        SeriesContent seriesContent = seriesContentMapper.map(request, contentType);
        seriesContent.setSeries(series);
        return seriesContentMapper.map(seriesContentService.createContent(seriesContent));
    }

    @Override
    public SeriesContentResponse updateContent(Long contentId, ContentUpdateRequest request) {
        SeriesContent content = seriesContentService.getContentById(contentId);
        SeriesContent updatedContent = seriesContentMapper.map(content, request);
        return seriesContentMapper.map(seriesContentService.updateContent(updatedContent));
    }

    @Override
    public List<SeriesContentResponse> getContentBySeries(Long seriesId, ContentType contentType) {
        Series series = seriesService.getSeriesById(seriesId);
        if (contentType == ContentType.ALL) {
            return seriesContentMapper.map(seriesContentService.getContentBySeries(series));
        }
        return seriesContentMapper.map(seriesContentService.getContentBySeriesAndContentType(series, contentType));
    }

    @Override
    public SeriesContentResponse getContentById(Long contentId) {
        return seriesContentMapper.map(seriesContentService.getContentById(contentId));
    }

    @Override
    public void removeAllContentBySeries(Long seriesId) {
        Series series = seriesService.getSeriesById(seriesId);
        seriesContentService.removeAllContentBySeries(series);
    }

    @Override
    public void removeContentById(Long contentId) {
        seriesContentService.removeContentById(contentId);
    }
}
