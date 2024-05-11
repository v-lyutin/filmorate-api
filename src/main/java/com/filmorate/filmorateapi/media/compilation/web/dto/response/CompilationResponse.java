package com.filmorate.filmorateapi.media.compilation.web.dto.response;

import com.filmorate.filmorateapi.media.movie.web.dto.response.MoviePreviewResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesPreviewResponse;
import com.filmorate.filmorateapi.user.web.dto.response.UserProfilePreviewResponse;

import java.util.Set;

public record CompilationResponse(
        long compilationId,

        UserProfilePreviewResponse author,

        Set<String> genres,

        String title,

        String description,

        Set<MoviePreviewResponse> movies,

        Set<SeriesPreviewResponse> series,

        long likesCount) {
}
