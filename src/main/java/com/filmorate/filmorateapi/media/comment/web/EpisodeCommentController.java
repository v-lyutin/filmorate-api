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

    @PutMapping(value = "comments/{commentId:\\d+}")
    public CommentResponse updateComment(@PathVariable(name = "commentId") Long commentId,
                                         @Valid @RequestBody CommentRequest request) {
        return episodeCommentUseCase.updateComment(commentId, request);
    }

    @GetMapping(value = "comments/{commentId:\\d+}")
    public CommentResponse getComment(@PathVariable(name = "commentId") Long commentId) {
        return episodeCommentUseCase.getCommentById(commentId);
    }

    @GetMapping(value = "{episodeId:\\d+}/comments")
    public CommentPageResponse getCommentsByMovie(@PathVariable(name = "episodeId") Long episodeId,
                                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                                  @RequestParam(name = "limit", defaultValue = "10") int limit) {
        CommentPageRequest request = new CommentPageRequest(page, limit);
        return episodeCommentUseCase.getCommentsByEpisode(episodeId, request);
    }

    @DeleteMapping(value = "comments/{commentId:\\d+}")
    public void removeComment(@PathVariable(name = "commentId") Long commentId) {
        episodeCommentUseCase.removeCommentById(commentId);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "{episodeId:\\d+}/comments")
    public void removeAllCommentsByMovie(@PathVariable(name = "episodeId") Long episodeId) {
        episodeCommentUseCase.removeAllCommentsByEpisode(episodeId);
    }
}
