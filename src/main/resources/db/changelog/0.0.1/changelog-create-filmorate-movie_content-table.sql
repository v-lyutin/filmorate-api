--liquibase formatted sql

--changeset v-lyutin:create-filmorate-movie_content-table
--comment create table filmorate.movie_content
create table filmorate.movie_content
(
    id           serial primary key,
    content_type varchar not null,
    title        varchar(50),
    content_url  varchar not null,
    movie_id     integer not null
);
--rollback drop table filmorate.movie_content;

--changeset v-lyutin:add-filmorate-movie-table-constraints
--comment add constraints to filmorate.movie table
alter table filmorate.movie_content
    add constraint movie_content__movie__fk
        foreign key (movie_id) references filmorate.movie (id);
--rollback alter table filmorate.movie_content drop constraint movie_content__movie__fk;
