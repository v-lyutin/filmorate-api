package com.filmorate.filmorateapi.media.content.web;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.usecase.EpisodeContentUseCase;
import com.filmorate.filmorateapi.media.content.util.ContentTypeEditor;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.EpisodeContentResponse;
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
@RequestMapping(value = "api/v1/series/episodes")
public class EpisodeContentController {
    private final EpisodeContentUseCase episodeContentUseCase;

    @InitBinder(value = "contentType")
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(ContentType.class, new ContentTypeEditor());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{episodeId:\\d+}/content")
    public EpisodeContentResponse addContent(@RequestParam(name = "contentType") ContentType contentType,
                                             @PathVariable(name = "episodeId") Long episodeId,
                                             @Valid @RequestBody ContentRequest request) {
        return episodeContentUseCase.createContent(episodeId, request, contentType);
    }

    @PutMapping(value = "content/{contentId:\\d+}")
    public EpisodeContentResponse updateContent(@PathVariable(name = "contentId") Long contentId,
                                                @Valid @RequestBody ContentUpdateRequest request) {
        return episodeContentUseCase.updateContent(contentId, request);
    }

    @GetMapping(value = "{episodeId:\\d+}/content")
    public List<EpisodeContentResponse> getContentByMovie(@RequestParam(name = "contentType", required = false, defaultValue = "ALL") ContentType contentType,
                                                          @PathVariable(name = "episodeId") Long episodeId) {
        return episodeContentUseCase.getContentByEpisode(episodeId, contentType);
    }

    @GetMapping(value = "content/{contentId:\\d+}")
    public EpisodeContentResponse getContentById(@PathVariable(name = "contentId") Long contentId) {
        return episodeContentUseCase.getContentById(contentId);
    }

    @DeleteMapping(value = "{episodeId:\\d+}/content")
    public void removeAllContentByMovie(@PathVariable(name = "episodeId") Long episodeId) {
        episodeContentUseCase.removeAllContentByEpisode(episodeId);
    }

    @DeleteMapping(value = "content/{contentId:\\d+}")
    public void removeContent(@PathVariable(name = "contentId") Long contentId) {
        episodeContentUseCase.removeContentById(contentId);
    }
}
