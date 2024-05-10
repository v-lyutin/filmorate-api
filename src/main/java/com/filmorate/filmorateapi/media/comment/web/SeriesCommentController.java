package com.filmorate.filmorateapi.media.comment.web;

import com.filmorate.filmorateapi.media.comment.usecase.SeriesCommentUseCase;
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
@RequestMapping("api/v1/series")
public class SeriesCommentController {
    private final SeriesCommentUseCase seriesCommentUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{seriesId:\\d+}/comments")
    public CommentResponse addComment(@PathVariable(name = "seriesId") Long seriesId,
                                      @Valid @RequestBody CommentRequest request) {
        return seriesCommentUseCase.createComment(seriesId, request);
    }

    @GetMapping(value = "{seriesId:\\d+}/comments")
    public CommentPageResponse getCommentsByMovie(@PathVariable(name = "seriesId") Long seriesId,
                                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                                  @RequestParam(name = "limit", defaultValue = "10") int limit) {
        CommentPageRequest request = new CommentPageRequest(page, limit);
        return seriesCommentUseCase.getCommentsBySeries(seriesId, request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "{seriesId:\\d+}/comments")
    public void removeAllCommentsByMovie(@PathVariable(name = "seriesId") Long seriesId) {
        seriesCommentUseCase.removeAllCommentsBySeries(seriesId);
    }
}
