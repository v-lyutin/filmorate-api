package com.filmorate.filmorateapi.media.content.usecase;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.MovieContentResponse;
import java.util.List;

public interface MovieContentUseCase {
    MovieContentResponse createContent(Long movieId, ContentRequest request, ContentType contentType);

    MovieContentResponse updateContent(Long contentId, ContentUpdateRequest request);

    List<MovieContentResponse> getContentByMovie(Long movieId, ContentType contentType);

    MovieContentResponse getContentById(Long contentId);

    void removeAllContentByMovie(Long movieId);

    void removeContentById(Long contentId);
}
