package com.filmorate.filmorateapi.media.content.mapper;

import com.filmorate.filmorateapi.media.content.model.Content;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.ContentResponse;
import java.util.List;

public interface ContentMapper {
    Content map(ContentRequest request);

    ContentResponse map(Content content);

    List<ContentResponse> map(List<Content> content);
}
