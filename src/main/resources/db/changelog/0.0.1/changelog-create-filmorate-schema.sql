--liquibase formatted sql

--changeset v-lyutin:create filmorate-schema
--comment create new schema
create schema filmorate;
--rollback drop schema filmorate;