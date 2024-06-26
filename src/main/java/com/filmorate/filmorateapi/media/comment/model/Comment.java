package com.filmorate.filmorateapi.media.comment.model;

import com.filmorate.filmorateapi.user.model.UserProfile;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(schema = "filmorate", name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant editedAt;

    @ManyToOne(optional = false)
    private UserProfile userProfile;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            schema = "filmorate",
            name = "comment_likes",
            joinColumns = { @JoinColumn(name = "comment_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "user_profile_id", referencedColumnName = "id") }
    )
    private Set<UserProfile> likedByUsers = new HashSet<>();

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            schema = "filmorate",
            name = "comment_dislikes",
            joinColumns = { @JoinColumn(name = "comment_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "user_profile_id", referencedColumnName = "id") }
    )
    private Set<UserProfile> dislikedByUsers = new HashSet<>();
}
