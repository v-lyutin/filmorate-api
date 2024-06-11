package com.filmorate.filmorateapi.media.content.web;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.usecase.MovieContentUseCase;
import com.filmorate.filmorateapi.media.content.util.ContentTypeEditor;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.MovieContentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "api/v1/movies")
public class MovieContentController {
    private final MovieContentUseCase contentUseCase;

    @InitBinder(value = "contentType")
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(ContentType.class, new ContentTypeEditor());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "{movieId:\\d+}/content")
    public MovieContentResponse addContent(@RequestParam(name = "contentType") ContentType contentType,
                                           @PathVariable(name = "movieId") Long movieId,
                                           @Valid @RequestBody ContentRequest request) {
        return contentUseCase.createContent(movieId, request, contentType);
    }

    @PutMapping(value = "content/{contentId:\\d+}")
    public MovieContentResponse updateContent(
            @PathVariable(name = "contentId") Long contentId,
            @Valid @RequestBody ContentUpdateRequest request) {
        return contentUseCase.updateContent(contentId, request);
    }

    @GetMapping(value = "{movieId:\\d+}/content")
    public List<MovieContentResponse> getContentByMovie(
            @RequestParam(name = "contentType", required = false, defaultValue = "ALL") ContentType contentType,
            @PathVariable(name = "movieId") Long movieId) {
        return contentUseCase.getContentByMovie(movieId, contentType);
    }

    @GetMapping(value = "content/{contentId:\\d+}")
    public MovieContentResponse getContentById(@PathVariable(name = "contentId") Long contentId) {
        return contentUseCase.getContentById(contentId);
    }

    @DeleteMapping(value = "{movieId:\\d+}/content")
    public void removeAllContentByMovie(@PathVariable(name = "movieId") Long movieId) {
        contentUseCase.removeAllContentByMovie(movieId);
    }

    @DeleteMapping(value = "content/{contentId:\\d+}")
    public void removeContent(@PathVariable(name = "contentId") Long contentId) {
        contentUseCase.removeContentById(contentId);
    }
}
