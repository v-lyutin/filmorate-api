--liquibase formatted sql

--changeset v-lyutin:create-filmorate-user_profiles-table
--comment create table filmorate.user_profiles
create table filmorate.user_profiles
(
    id         integer primary key,
    nickname   varchar(32)  not null,
    image_link varchar(128)
);
--rollback drop table filmorate.user_profiles;

--changeset v-lyutin:add-filmorate-user_profiles-table-constraints
--comment add constraints to filmorate.user_profiles table
alter table filmorate.user_profiles
    add constraint user_profiles__user_accounts__fk
        foreign key (id) references identity.user_accounts (id);

alter table filmorate.user_profiles
    add constraint user_profiles__nickname__unique
        unique (nickname);
--rollback alter table filmorate.user_profiles drop constraint user_profiles__user_accounts__fk;
--rollback alter table filmorate.user_profiles drop constraint user_profiles__nickname__unique;