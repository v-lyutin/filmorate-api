package com.filmorate.filmorateapi.media.movie.web.dto.response;

import java.util.Collection;

public record MoviesPageResponse(
        long totalPages,
        boolean isFirstPage,
        boolean isLastPage,
        long totalMovies,
        Collection<MoviePreviewResponse> movies) {
}
