package com.filmorate.filmorateapi.media.content.mapper;

import com.filmorate.filmorateapi.media.content.model.MovieContent;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.MovieContentResponse;
import java.util.List;

public interface MovieContentMapper {
    MovieContent map(ContentRequest request, ContentType contentType);

    MovieContent map(MovieContent content, ContentUpdateRequest request);

    MovieContentResponse map(MovieContent content);

    List<MovieContentResponse> map(List<MovieContent> content);
}
