package com.filmorate.filmorateapi.media.content.mapper;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.model.SeriesContent;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.SeriesContentResponse;
import java.util.List;

public interface SeriesContentMapper {
    SeriesContent map(ContentRequest request, ContentType contentType);

    SeriesContent map(SeriesContent content, ContentUpdateRequest request);

    SeriesContentResponse map(SeriesContent content);

    List<SeriesContentResponse> map(List<SeriesContent> content);
}
