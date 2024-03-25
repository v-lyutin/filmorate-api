package com.filmorate.filmorateapi.media.content.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(schema = "filmorate", name = "content_types")
public class ContentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
