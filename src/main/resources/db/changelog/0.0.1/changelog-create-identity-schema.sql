--liquibase formatted sql

--changeset v-lyutin:create-identity-schema
--comment create new identity schema
create schema identity;
--rollback drop schema identity;

--changeset v-lyutin:create-identity-user_accounts-table
--comment create table identity.user_accounts
create table identity.user_accounts
(
    id       serial primary key,
    email    varchar(32) unique not null,
    password varchar(128)       not null
);
--rollback drop table identity.user_accounts;

--changeset v-lyutin:create-identity-user_roles-table
--comment create table identity.user_roles
create table identity.user_roles
(
    id        serial primary key,
    authority varchar(32) unique not null
);
--rollback drop table identity.user_roles;

--changeset v-lyutin:create-identity-user_accounts_roles-table
--comment create table identity.user_accounts_roles
create table identity.user_accounts_roles
(
    user_account_id integer not null,
    user_role_id    integer not null
);
--rollback drop table identity.user_accounts_roles;

--changeset v-lyutin:add-user_accounts_roles-table-constraints
--comment add constraints to user_accounts_roles
alter table identity.user_accounts_roles
    add constraint user_accounts_roles__user_roles_fk
        foreign key (user_role_id) references identity.user_roles (id);

alter table identity.user_accounts_roles
    add constraint user_accounts_roles__user_accounts_fk
        foreign key (user_account_id) references identity.user_accounts (id);

alter table identity.user_accounts_roles
    add constraint user_accounts_roles_unique
        unique (user_account_id, user_role_id);
--rollback alter table identity.user_accounts_roles drop constraint user_accounts_roles__user_roles_fk;
--rollback alter table identity.user_accounts_roles drop constraint user_accounts_roles__user_accounts_fk;
--rollback alter table identity.user_accounts_roles drop constraint user_accounts_roles_unique;

--changeset v-lyutin:add-data-to-user_roles_table
--comment add roles to user_roles table
insert into identity.user_roles(authority)
values ('ROLE_USER'),
       ('ROLE_ADMIN');
--rollback truncate table identity.user_roles

--changeset v-lyutin:add-support-role-to-user_roles_table
--comment add support-role to user_roles table
insert into identity.user_roles(authority)
values ('ROLE_SUPPORT');
--rollback truncate table identity.user_roles