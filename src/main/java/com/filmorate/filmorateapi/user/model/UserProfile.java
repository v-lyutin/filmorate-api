package com.filmorate.filmorateapi.user.model;

import com.filmorate.filmorateapi.media.person.model.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(schema = "filmorate", name = "user_profiles")
public class UserProfile {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String nickname;

    private String imageLink;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @ManyToMany
    @JoinTable(
            schema = "filmorate",
            name = "favorite_persons",
            joinColumns = {
                    @JoinColumn(name = "user_profile_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "person_id", referencedColumnName = "id")
            }
    )
    private Set<Person> favoritePersons = new HashSet<>();
}
