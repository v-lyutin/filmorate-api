package com.filmorate.filmorateapi.media.content.usecase;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.SeriesContentResponse;
import java.util.List;

public interface SeriesContentUseCase {
    SeriesContentResponse createContent(Long seriesId, ContentRequest request, ContentType contentType);

    SeriesContentResponse updateContent(Long contentId, ContentUpdateRequest request);

    List<SeriesContentResponse> getContentBySeries(Long seriesId, ContentType contentType);

    SeriesContentResponse getContentById(Long contentId);

    void removeAllContentBySeries(Long seriesId);

    void removeContentById(Long contentId);
}
