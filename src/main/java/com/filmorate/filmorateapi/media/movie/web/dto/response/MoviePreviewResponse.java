package com.filmorate.filmorateapi.media.movie.web.dto.response;

import java.util.List;

public record MoviePreviewResponse(
        long id,
        String posterUrl,
        String title,
        String originalTitle,
        List<String> genres,
        long likesCount) {
}
