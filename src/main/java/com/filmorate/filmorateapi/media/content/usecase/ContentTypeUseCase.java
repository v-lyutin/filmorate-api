package com.filmorate.filmorateapi.media.content.usecase;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentTypeRequest;
import java.util.List;

public interface ContentTypeUseCase {
    ContentType createContent(ContentTypeRequest request);

    List<ContentType> getAllContentTypes();
}
