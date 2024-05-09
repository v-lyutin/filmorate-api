package com.filmorate.filmorateapi.media.series.web.dto.response;

import java.util.Collection;

public record SeriesPageResponse(
        long totalPages,
        boolean isFirstPage,
        boolean isLastPage,
        long totalSeries,
        Collection<SeriesPreviewResponse> series) {
}
