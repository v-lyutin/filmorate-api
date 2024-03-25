package com.filmorate.filmorateapi.media.content.usecase;

import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.ContentResponse;
import java.util.List;

public interface ContentUseCase {
    ContentResponse createContent(Long movieId, ContentRequest request);

    List<ContentResponse> getContentByMovie(Long movieId);

    void removeAllContentByMovie(Long movieId);

    void removeContentById(Long movieId, Long contentId);
}
