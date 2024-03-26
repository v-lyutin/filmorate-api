package com.filmorate.filmorateapi.media.content.service.impl;

import com.filmorate.filmorateapi.media.content.exception.ContentTypeServiceException;
import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.repository.ContentTypeRepository;
import com.filmorate.filmorateapi.media.content.service.ContentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentTypeServiceImpl implements ContentTypeService {
    private final ContentTypeRepository contentTypeRepository;

    @Override
    public ContentType createContentType(ContentType contentType) {
        if (contentType == null) {
            throw new ContentTypeServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "The 'contentType' variable is null");
        }
        if (contentTypeRepository.existsByNameIgnoreCase(contentType.getName())) {
            throw new ContentTypeServiceException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Content type with name '%s' already exists", contentType.getName())
            );
        }
        return contentTypeRepository.save(contentType);
    }

    @Override
    public ContentType getContentTypeById(Long id) {
        return contentTypeRepository.findById(id)
                .orElseThrow(() -> new ContentTypeServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Content type with ID = '%d' not found", id)));
    }

    @Override
    public ContentType getContentTypeByName(String name) {
        return contentTypeRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new ContentTypeServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Content type with name = '%s' not found", name)));
    }

    @Override
    public List<ContentType> getAllContentTypes() {
        return contentTypeRepository.findAll();
    }

    @Override
    public ContentType updateContentType(ContentType contentType) {
        return null;
    }

    @Override
    public void removeContentTypeById(Long id) {
        contentTypeRepository.deleteById(id);
    }
}
