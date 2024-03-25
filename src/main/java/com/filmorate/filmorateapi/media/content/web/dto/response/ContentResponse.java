package com.filmorate.filmorateapi.media.content.web.dto.response;

public record ContentResponse (
    long id,

    String title,

    String contentUrl,

    String contentType,

    long movieId) {
}
