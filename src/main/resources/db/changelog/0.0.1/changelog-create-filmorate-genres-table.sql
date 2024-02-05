--liquibase formatted sql

--changeset v-lyutin:create-filmorate-genres-table
--comment create table filmorate.genres
create table filmorate.genres
(
    id   serial primary key,
    name varchar(32) not null
);
--rollback drop table filmorate.genres;

--changeset v-lyutin:add-filmorate-genres-table-constraints
--comment add constraints to filmorate.genres table
alter table filmorate.genres
    add constraint genres__name__unique
        unique (name);
--rollback alter table filmorate.genres drop constraint genres__name__unique;

--changeset v-lyutin:add-data-to-filmorate.genres-table
--comment add roles to filmorate.genres table
insert into filmorate.genres(name)
values ('comedy'),
       ('science fiction'),
       ('mystery'),
       ('musical'),
       ('documentary'),
       ('romance'),
       ('fantasy'),
       ('crime'),
       ('thriller'),
       ('western'),
       ('historical'),
       ('experimental'),
       ('adventure'),
       ('horror'),
       ('animation'),
       ('sports'),
       ('action'),
       ('drama');
--rollback truncate table filmorate.genres