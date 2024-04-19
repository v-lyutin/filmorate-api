package com.filmorate.filmorateapi.media.content.usecase;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.ContentResponse;
import java.util.List;

public interface ContentUseCase {
    ContentResponse createContent(Long movieId, ContentRequest request, ContentType contentType);

    ContentResponse updateContent(Long contentId, ContentUpdateRequest request);

    List<ContentResponse> getContentByMovie(Long movieId, ContentType contentType);

    ContentResponse getContentById(Long contentId);

    void removeAllContentByMovie(Long movieId);

    void removeContentById(Long contentId);
}
