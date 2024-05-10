package com.filmorate.filmorateapi.media.comment.repository;

import com.filmorate.filmorateapi.media.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT COUNT(l) FROM Comment c LEFT JOIN c.likedByUsers l WHERE c.id = :id")
    Long getCommentLikeCount(@Param("id") Long id);

    @Query("SELECT COUNT(l) FROM Comment c LEFT JOIN c.dislikedByUsers l WHERE c.id = :id")
    Long getCommentDislikeCount(@Param("id") Long id);
}
