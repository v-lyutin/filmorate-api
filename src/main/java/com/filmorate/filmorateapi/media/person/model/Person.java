package com.filmorate.filmorateapi.media.person.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.filmorate.filmorateapi.media.career.model.Career;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(schema = "filmorate", name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageLink;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column(nullable = false)
    private Integer height;

    @ManyToMany
    @JoinTable(
            schema = "filmorate",
            name = "persons_careers",
            joinColumns = { @JoinColumn(name = "person_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "career_id", referencedColumnName = "id") }
    )
    private Set<Career> careers = new HashSet<>();
}
