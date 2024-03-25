package com.filmorate.filmorateapi.media.content.web;

import com.filmorate.filmorateapi.media.content.usecase.ContentUseCase;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.ContentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "api/v1/movies")
public class ContentController {
    private final ContentUseCase contentUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{movieId:\\d+}/content")
    public ContentResponse addContent(
            @PathVariable(name = "movieId") Long movieId,
            @Valid @RequestBody ContentRequest request) {
        return contentUseCase.createContent(movieId, request);
    }

    @GetMapping(value = "{movieId:\\d+}/content")
    public List<ContentResponse> getContentByMovie(@PathVariable(name = "movieId") Long movieId) {
        return contentUseCase.getContentByMovie(movieId);
    }

    @DeleteMapping(value = "{movieId:\\d+}/content")
    public void removeAllContentByMovieId(@PathVariable(name = "movieId") Long movieId) {
        contentUseCase.removeAllContentByMovie(movieId);
    }

    @DeleteMapping(value = "{movieId:\\d+}/content/{contentId:\\d+}")
    public void removeContent(
            @PathVariable(name = "movieId") Long movieId,
            @PathVariable(name = "contentId") Long contentId) {
        contentUseCase.removeContentById(movieId, contentId);
    }
}
