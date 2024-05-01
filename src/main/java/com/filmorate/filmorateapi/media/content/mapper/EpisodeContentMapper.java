package com.filmorate.filmorateapi.media.content.mapper;

import com.filmorate.filmorateapi.media.content.model.ContentType;
import com.filmorate.filmorateapi.media.content.model.EpisodeContent;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentRequest;
import com.filmorate.filmorateapi.media.content.web.dto.request.ContentUpdateRequest;
import com.filmorate.filmorateapi.media.content.web.dto.response.EpisodeContentResponse;
import java.util.List;

public interface EpisodeContentMapper {
    EpisodeContent map(ContentRequest request, ContentType contentType);

    EpisodeContent map(EpisodeContent content, ContentUpdateRequest request);

    EpisodeContentResponse map(EpisodeContent content);

    List<EpisodeContentResponse> map(List<EpisodeContent> content);
}
