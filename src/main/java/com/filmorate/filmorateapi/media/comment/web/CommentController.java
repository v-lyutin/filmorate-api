package com.filmorate.filmorateapi.media.comment.web;

import com.filmorate.filmorateapi.media.comment.usecase.CommentCommonUseCase;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/comments")
public class CommentController {
    private final CommentCommonUseCase commentCommonUseCase;

    @PostMapping(value = "{commentId:\\d+}/like")
    public void toggleLike(@PathVariable("commentId") Long commentId) {
        commentCommonUseCase.toggleLike(commentId);
    }

    @PostMapping(value = "{commentId:\\d+}/dislike")
    public void toggleDislike(@PathVariable("commentId") Long commentId) {
        commentCommonUseCase.toggleDislike(commentId);
    }

    @PutMapping(value = "{commentId:\\d+}")
    public CommentResponse updateComment(@PathVariable(name = "commentId") Long commentId,
                                         @Valid @RequestBody CommentRequest request) {
        return commentCommonUseCase.updateComment(commentId, request);
    }

    @GetMapping(value = "{commentId:\\d+}")
    public CommentResponse getComment(@PathVariable(name = "commentId") Long commentId) {
        return commentCommonUseCase.getCommentById(commentId);
    }

    @DeleteMapping(value = "{commentId:\\d+}")
    public void removeComment(@PathVariable(name = "commentId") Long commentId) {
        commentCommonUseCase.removeCommentById(commentId);
    }
}
