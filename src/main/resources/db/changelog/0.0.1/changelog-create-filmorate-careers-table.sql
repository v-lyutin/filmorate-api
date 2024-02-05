--liquibase formatted sql

--changeset v-lyutin:create-filmorate-careers-table
--comment create table filmorate.careers
create table filmorate.careers
(
    id   serial primary key,
    name varchar(32) not null
);
--rollback drop table filmorate.careers;

--changeset v-lyutin:add-filmorate-careers-table-constraints
--comment add constraints to filmorate.careers table
alter table filmorate.careers
    add constraint careers__name__unique
        unique (name);
--rollback alter table filmorate.careers drop constraint careers__name__unique;
