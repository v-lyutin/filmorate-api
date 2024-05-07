--liquibase formatted sql

--changeset v-lyutin:create-filmorate-movie-table
--comment create table filmorate.movie
create table filmorate.movie
(
    id             serial primary key,
    poster_url     varchar       not null,
    title          varchar(32)   not null,
    original_title varchar(32)   not null,
    description    varchar(1000) not null,
    release_year   integer       not null,
    country        varchar(20)   not null,
    duration       integer       not null
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

--changeset v-lyutin:create-filmorate-movie_likes-table
--comment create table filmorate.movie_likes
create table filmorate.movie_likes
(
    movie_id integer not null,
    user_profile_id integer not null
);
--rollback drop table filmorate.movie_likes;

--changeset v-lyutin:add-movie_likes-table-constraints
--comment add constraints to movie_likes
alter table filmorate.movie_likes
    add constraint movie_likes__user_profile_fk
        foreign key (user_profile_id) references filmorate.user_profiles (id);

alter table filmorate.movie_likes
    add constraint movie_likes__movie_fk
        foreign key (movie_id) references filmorate.movie (id);

alter table filmorate.movie_likes
    add constraint movie_likes_unique
        unique (movie_id, user_profile_id);
--rollback alter table filmorate.movie_likes drop constraint movie_likes__user_profile_fk;
--rollback alter table filmorate.movie_likes drop constraint movie_likes__movie_fk;
--rollback alter table filmorate.movie_likes drop constraint movie_likes_unique;
