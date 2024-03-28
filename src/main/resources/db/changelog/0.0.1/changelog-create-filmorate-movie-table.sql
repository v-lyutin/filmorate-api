--liquibase formatted sql

--changeset v-lyutin:create-filmorate-movie-table
--comment create table filmorate.movie
create table filmorate.movie
(
    id           serial primary key,
    title        varchar(32)  not null,
    en_title     varchar(32)  not null,
    description  varchar(500) not null,
    release_year integer      not null,
    country      varchar(20)  not null,
    duration     integer      not null,
    created_at   timestamp    not null
);
--rollback drop table filmorate.movie;

--changeset v-lyutin:create-filmorate-movie_genres-table
--comment create table filmorate.movie_genres
create table filmorate.movie_genres
(
    movie_id integer not null,
    genre_id integer not null
);
--rollback drop table filmorate.movie_genres;

--changeset v-lyutin:add-movie_genres-table-constraints
--comment add constraints to movie_genres
alter table filmorate.movie_genres
    add constraint movie_genres__genres_fk
        foreign key (genre_id) references filmorate.genres (id);

alter table filmorate.movie_genres
    add constraint movie_genres__movie_fk
        foreign key (movie_id) references filmorate.movie (id);

alter table filmorate.movie_genres
    add constraint movie_genres_unique
        unique (movie_id, genre_id);
--rollback alter table filmorate.movie_genres drop constraint movie_genres__genres_fk;
--rollback alter table filmorate.movie_genres drop constraint movie_genres__movie_fk;
--rollback alter table filmorate.movie_genres drop constraint movie_genres_unique;
