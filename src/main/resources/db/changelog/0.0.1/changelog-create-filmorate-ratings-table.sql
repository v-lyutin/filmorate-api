--liquibase formatted sql

--changeset v-lyutin:create-filmorate-mpaa_ratings-table
--comment create table filmorate.mpaa_ratings
create table filmorate.mpaa_ratings
(
    id          serial primary key,
    name        varchar(32)   not null,
    description varchar(1000) not null
);
--rollback drop table filmorate.mpaa_ratings;

--changeset v-lyutin:add-filmorate-mpaa_ratings-table-constraints
--comment add constraints to filmorate.mpaa_ratings table
alter table filmorate.mpaa_ratings
    add constraint mpaa_ratings__name__unique
        unique (name);
--rollback alter table filmorate.mpaa_ratings drop constraint mpaa_ratings__name__unique;

--changeset v-lyutin:add-data-to-mpaa_ratings-table
--comment add roles to mpaa_ratings table
insert into filmorate.mpaa_ratings(name, description)
values ('G', '(General Audiences) — фильм подходит для всех возрастов'),
       ('PG', '(Parental Guidance Suggested) — фильм может не подходить для детей младше 8 лет'),
       ('PG-13', '(Parents Strongly Cautioned) — фильм может содержать сцены насилия, употребления наркотиков или нецензурной лексики'),
       ('R', '(Restricted) — дети до 17 лет допускаются на фильм только в сопровождении взрослых'),
       ('NC-17', '(No One 17 and Under Admitted) — фильм не рекомендуется для детей до 18 лет');
--rollback truncate table filmorate.mpaa_ratings

--changeset v-lyutin:create-filmorate-rars_ratings-table
--comment create table filmorate.rars_ratings
create table filmorate.rars_ratings
(
    id          serial primary key,
    name        varchar(32)   not null,
    description varchar(1000) not null
);
--rollback drop table filmorate.rars_ratings;

--changeset v-lyutin:add-filmorate-rars_ratings-table-constraints
--comment add constraints to filmorate.rars_ratings table
alter table filmorate.rars_ratings
    add constraint rars_ratings__name__unique
        unique (name);
--rollback alter table filmorate.rars_ratings drop constraint rars_ratings__name__unique;

--changeset v-lyutin:add-data-to-rars_ratings-table
--comment add roles to rars_ratings table
insert into filmorate.rars_ratings(name, description)
values ('0+', 'информационная продукция, которая может быть доступна без ограничений'),
       ('6+', 'информационная продукция, содержащая информацию, не причиняющую вреда здоровью и (или) развитию детей'),
       ('12+', 'информационная продукция, вызывающая у детей потребность в защите со стороны взрослых'),
       ('16+', 'информационная продукция, запрещённая для детей до 16 лет'),
       ('18+', 'информационная продукция, запрещённая для детей');
--rollback truncate table filmorate.rars_ratings