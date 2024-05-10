package com.filmorate.filmorateapi.media.comment.web;

import com.filmorate.filmorateapi.media.comment.usecase.MovieCommentUseCase;
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
@RequestMapping("api/v1/movies")
public class MovieCommentController {
    private final MovieCommentUseCase movieCommentUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{movieId:\\d+}/comments")
    public CommentResponse addComment(@PathVariable(name = "movieId") Long movieId,
                                      @Valid @RequestBody CommentRequest request) {
        return movieCommentUseCase.createComment(movieId, request);
    }

    @GetMapping(value = "{movieId:\\d+}/comments")
    public CommentPageResponse getCommentsByMovie(@PathVariable(name = "movieId") Long movieId,
                                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                                  @RequestParam(name = "limit", defaultValue = "10") int limit) {
        CommentPageRequest request = new CommentPageRequest(page, limit);
        return movieCommentUseCase.getCommentsByMovie(movieId, request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "{movieId:\\d+}/comments")
    public void removeAllCommentsByMovie(@PathVariable(name = "movieId") Long movieId) {
        movieCommentUseCase.removeAllCommentsByMovie(movieId);
    }
}
