package com.filmorate.filmorateapi.media.content.web.dto.response;

import com.filmorate.filmorateapi.media.content.model.ContentType;

public record SeriesContentResponse(
        long id,

        String title,

        String contentUrl,

        ContentType contentType,

        long seriesId) {
}
