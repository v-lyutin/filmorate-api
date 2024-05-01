package com.filmorate.filmorateapi.media.content.web;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.usecase.SeriesContentUseCase;
import com.filmorate.filmorateapi.media.content.util.ContentTypeEditor;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.SeriesContentResponse;
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
@RequestMapping(value = "api/v1/series")
public class SeriesContentController {
    private final SeriesContentUseCase seriesContentUseCase;

    @InitBinder(value = "contentType")
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(ContentType.class, new ContentTypeEditor());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{seriesId:\\d+}/content")
    public SeriesContentResponse addContent(@RequestParam(name = "contentType") ContentType contentType,
                                            @PathVariable(name = "seriesId") Long seriesId,
                                            @Valid @RequestBody ContentRequest request) {
        return seriesContentUseCase.createContent(seriesId, request, contentType);
    }

    @PutMapping(value = "content/{contentId:\\d+}")
    public SeriesContentResponse updateContent(@PathVariable(name = "contentId") Long contentId,
                                               @Valid @RequestBody ContentUpdateRequest request) {
        return seriesContentUseCase.updateContent(contentId, request);
    }

    @GetMapping(value = "{seriesId:\\d+}/content")
    public List<SeriesContentResponse> getContentByMovie(@RequestParam(name = "contentType", required = false, defaultValue = "ALL") ContentType contentType,
                                                         @PathVariable(name = "seriesId") Long seriesId) {
        return seriesContentUseCase.getContentBySeries(seriesId, contentType);
    }

    @GetMapping(value = "content/{contentId:\\d+}")
    public SeriesContentResponse getContentById(@PathVariable(name = "contentId") Long contentId) {
        return seriesContentUseCase.getContentById(contentId);
    }

    @DeleteMapping(value = "{seriesId:\\d+}/content")
    public void removeAllContentByMovie(@PathVariable(name = "seriesId") Long seriesId) {
        seriesContentUseCase.removeAllContentBySeries(seriesId);
    }

    @DeleteMapping(value = "content/{contentId:\\d+}")
    public void removeContent(@PathVariable(name = "contentId") Long contentId) {
        seriesContentUseCase.removeContentById(contentId);
    }
}
