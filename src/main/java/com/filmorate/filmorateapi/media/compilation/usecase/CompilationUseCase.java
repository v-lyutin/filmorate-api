package com.filmorate.filmorateapi.media.compilation.usecase;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.compilation.web.dto.request.CompilationCreationRequest;
import com.filmorate.filmorateapi.media.compilation.web.dto.request.CompilationUpdateRequest;
import com.filmorate.filmorateapi.media.compilation.web.dto.response.CompilationPageResponse;
import com.filmorate.filmorateapi.media.compilation.web.dto.response.CompilationResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CompilationUseCase {
    CompilationResponse createCompilation(CompilationCreationRequest request);

    CompilationResponse updateCompilation(Long compilationId, CompilationUpdateRequest request);

    CompilationPageResponse searchCompilations(@Valid PageFindRequest pageFindRequest);

    CompilationResponse getCompilationById(Long compilationId);

    void removeCompilation(Long compilationId);

    void toggleLike(Long compilationId);

    void toggleMovie(Long compilationId, Long movieId);

    void toggleSeries(Long compilationId, Long seriesId);
}
