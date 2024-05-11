package com.filmorate.filmorateapi.media.compilation.web.dto.response;

import java.util.Collection;

public record CompilationPageResponse(
        long totalPages,

        boolean isFirstPage,

        boolean isLastPage,

        long totalCompilations,

        Collection<CompilationPreviewResponse> compilations) {
}
