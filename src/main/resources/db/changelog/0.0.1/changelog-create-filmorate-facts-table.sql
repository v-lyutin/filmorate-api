--liquibase formatted sql

--changeset v-lyutin:create-filmorate-facts-table
--comment create table filmorate.table
create table filmorate.facts
(
    id         serial primary key,
    fact_type  varchar(20)  not null,
    entity_id  integer      not null,
    text       varchar(300) not null,
    created_at timestamp    not null,
    edited_at  timestamp    not null
);
--rollback drop table filmorate.facts;
