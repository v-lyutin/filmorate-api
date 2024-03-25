package com.filmorate.filmorateapi.media.content.web;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.usecase.ContentTypeUseCase;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentTypeRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "api/v1/movies/content")
public class ContentTypeController {
    private final ContentTypeUseCase contentTypeUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContentType addContent(@Valid @RequestBody ContentTypeRequest request) {
        return contentTypeUseCase.createContent(request);
    }

    @GetMapping
    public List<ContentType> getAllContentTypes() {
        return contentTypeUseCase.getAllContentTypes();
    }
}
