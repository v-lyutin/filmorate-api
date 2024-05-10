package com.filmorate.filmorateapi.media.comment.web;

import com.filmorate.filmorateapi.media.comment.usecase.EpisodeCommentUseCase;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentPageRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentPageResponse;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/series/episodes")
public class EpisodeCommentController {
    private final EpisodeCommentUseCase episodeCommentUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{episodeId:\\d+}/comments")
    public CommentResponse addComment(@PathVariable(name = "episodeId") Long episodeId,
                                      @Valid @RequestBody CommentRequest request) {
        return episodeCommentUseCase.createComment(episodeId, request);
    }

    @GetMapping(value = "{episodeId:\\d+}/comments")
    public CommentPageResponse getCommentsByEpisode(@PathVariable(name = "episodeId") Long episodeId,
                                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                                    @RequestParam(name = "limit", defaultValue = "10") int limit) {
        CommentPageRequest request = new CommentPageRequest(page, limit);
        return episodeCommentUseCase.getCommentsByEpisode(episodeId, request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "{episodeId:\\d+}/comments")
    public void removeAllCommentsByMovie(@PathVariable(name = "episodeId") Long episodeId) {
        episodeCommentUseCase.removeAllCommentsByEpisode(episodeId);
    }
}
