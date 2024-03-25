package com.filmorate.filmorateapi.media.content.usecase.impl;

import com.filmorate.filmorateapi.media.content.mapper.ContentTypeMapper;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.service.ContentTypeService;
import com.filmorate.filmorateapi.media.content.usecase.ContentTypeUseCase;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentTypeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ContentTypeUseCaseFacade implements ContentTypeUseCase {
    private final ContentTypeService contentTypeService;
    private final ContentTypeMapper contentTypeMapper;

    @Override
    public ContentType createContent(ContentTypeRequest request) {
        return contentTypeService.createContentType(contentTypeMapper.map(request));
    }

    @Override
    public List<ContentType> getAllContentTypes() {
        return contentTypeService.getAllContentTypes();
    }
}
