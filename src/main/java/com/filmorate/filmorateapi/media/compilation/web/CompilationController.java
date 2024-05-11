package com.filmorate.filmorateapi.media.compilation.web;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.compilation.usecase.CompilationUseCase;
import com.filmorate.filmorateapi.media.compilation.web.dto.request.CompilationCreationRequest;
import com.filmorate.filmorateapi.media.compilation.web.dto.request.CompilationUpdateRequest;
import com.filmorate.filmorateapi.media.compilation.web.dto.response.CompilationPageResponse;
import com.filmorate.filmorateapi.media.compilation.web.dto.response.CompilationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/compilations")
public class CompilationController {
    private final CompilationUseCase compilationUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompilationResponse createCompilation(@Valid @RequestBody CompilationCreationRequest request) {
        return compilationUseCase.createCompilation(request);
    }

    @PatchMapping(value = "{compilationId:\\d+}")
    public CompilationResponse updateCompilation(@PathVariable(name = "compilationId") Long compilationId,
                                                 @Valid @RequestBody CompilationUpdateRequest request) {
        return compilationUseCase.updateCompilation(compilationId, request);
    }

    @GetMapping(value = "search")
    public CompilationPageResponse searchCompilations(@RequestParam(name = "page", defaultValue = "0") int page,
                                                      @RequestParam(name = "limit", defaultValue = "10") int limit) {
        PageFindRequest pageFindRequest = new PageFindRequest(page, limit);
        return compilationUseCase.searchCompilations(pageFindRequest);
    }

    @GetMapping(value = "{compilationId:\\d+}")
    public CompilationResponse getCompilation(@PathVariable(name = "compilationId") Long compilationId) {
        return compilationUseCase.getCompilationById(compilationId);
    }

    @DeleteMapping(value = "{compilationId:\\d+}")
    public void removeCompilation(@PathVariable(name = "compilationId") Long compilationId) {
        compilationUseCase.removeCompilation(compilationId);
    }

    @PostMapping(value = "{compilationId:\\d+}/like")
    public void toggleLike(@PathVariable(name = "compilationId") Long compilationId) {
        compilationUseCase.toggleLike(compilationId);
    }

    @PostMapping(value = "{compilationId:\\d+}/movies/{movieId:\\d+}")
    public void addMovieToCompilation(@PathVariable(name = "compilationId") Long compilationId,
                                      @PathVariable(name = "movieId") Long movieId) {
        compilationUseCase.toggleMovie(compilationId, movieId);
    }

    @PostMapping(value = "{compilationId:\\d+}/series/{seriesId:\\d+}")
    public void addSeriesToCompilation(@PathVariable(name = "compilationId") Long compilationId,
                                       @PathVariable(name = "seriesId") Long seriesId) {
        compilationUseCase.toggleSeries(compilationId, seriesId);
    }
}
