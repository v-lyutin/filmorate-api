package com.filmorate.filmorateapi.media.comment.mapper;

import com.filmorate.filmorateapi.media.comment.model.Comment;
import com.filmorate.filmorateapi.media.comment.model.EpisodeComment;
import com.filmorate.filmorateapi.media.comment.model.MovieComment;
import com.filmorate.filmorateapi.media.comment.model.SeriesComment;
import com.filmorate.filmorateapi.media.comment.web.dto.request.CommentRequest;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentPageResponse;
import com.filmorate.filmorateapi.media.comment.web.dto.response.CommentResponse;
import com.filmorate.filmorateapi.user.model.UserProfile;
import org.springframework.data.domain.Page;

public interface CommentMapper {
    Comment map(UserProfile userProfile, CommentRequest commentRequest);

    CommentResponse map(Comment comment);

    CommentPageResponse commentPageFromMovieComments(Page<MovieComment> comments);

    CommentPageResponse commentPageFromSeriesComments(Page<SeriesComment> comments);

    CommentPageResponse commentPageFromEpisodeComments(Page<EpisodeComment> comments);
}
