--liquibase formatted sql

--changeset v-lyutin:create-filmorate-content_types-table
--comment create table filmorate.content_types
create table filmorate.content_types
(
    id   serial primary key,
    name varchar(32) not null
);
--rollback drop table filmorate.content_types;

--changeset v-lyutin:create-filmorate-movie_content-table
--comment create table filmorate.movie_content
create table filmorate.movie_content
(
    id              serial primary key,
    title           varchar(50),
    content_url     varchar not null,
    content_type_id integer not null,
    movie_id        integer not null
);
--rollback drop table filmorate.movie_content;

--changeset v-lyutin:add-filmorate-content_types-table-constraints
--comment add constraints to filmorate.movie_content table
alter table filmorate.movie_content
    add constraint movie_content__content_type__fk
        foreign key (content_type_id) references filmorate.content_types (id);
--rollback alter table filmorate.movie_content drop constraint movie_content__content_type__fk;

--changeset v-lyutin:add-filmorate-movie-table-constraints
--comment add constraints to filmorate.movie table
alter table filmorate.movie_content
    add constraint movie_content__movie__fk
        foreign key (movie_id) references filmorate.movie (id);
--rollback alter table filmorate.movie_content drop constraint movie_content__movie__fk;