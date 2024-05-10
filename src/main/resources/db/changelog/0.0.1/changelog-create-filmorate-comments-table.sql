--liquibase formatted sql

--changeset v-lyutin:create-filmorate-comments-table
--comment create table filmorate.comments
create table filmorate.comments
(
    id              serial primary key,
    text            varchar(180) not null,
    created_at      timestamp    not null,
    edited_at       timestamp    not null,
    user_profile_id integer      not null
);
--rollback drop table filmorate.comments;

--changeset v-lyutin:add-filmorate.comments-table-constraints
--comment add constraints to filmorate.comments table
alter table filmorate.comments
    add constraint comments__user_profiles__fk
        foreign key (user_profile_id) references filmorate.user_profiles (id);
--rollback alter table filmorate.tweets drop constraint comments__user_profiles__fk;

--changeset v-lyutin:create-filmorate-movie_comments-table
--comment create table filmorate.movie_comments
create table filmorate.movie_comments
(
    id         serial primary key,
    movie_id   integer not null,
    comment_id integer not null
);
--rollback drop table filmorate.movie_comments;

--changeset v-lyutin:add-filmorate-movie_comments-table-constraints
--comment add constraints to filmorate.movie_comments table
alter table filmorate.movie_comments
    add constraint movie_comments__movie__fk
        foreign key (movie_id) references filmorate.movie (id);

alter table filmorate.movie_comments
    add constraint movie_comments__comment__fk
        foreign key (comment_id) references filmorate.comments (id) ON DELETE CASCADE;
--rollback alter table filmorate.movie_comments drop constraint movie_comments__movie__fk;
--rollback alter table filmorate.movie_comments drop constraint movie_comments__comment__fk;

--changeset v-lyutin:create-filmorate-series_comments-table
--comment create table filmorate.series_comments
create table filmorate.series_comments
(
    id         serial primary key,
    series_id  integer not null,
    comment_id integer not null
);
--rollback drop table filmorate.series_comments;

--changeset v-lyutin:add-filmorate-series_comments-table-constraints
--comment add constraints to filmorate.series_comments table
alter table filmorate.series_comments
    add constraint series_comments__series__fk
        foreign key (series_id) references filmorate.series (id);

alter table filmorate.series_comments
    add constraint series_comments__comment__fk
        foreign key (comment_id) references filmorate.comments (id) ON DELETE CASCADE;
--rollback alter table filmorate.series_comments drop constraint series_comments__series__fk;
--rollback alter table filmorate.series_comments drop constraint series_comments__comment__fk;

--changeset v-lyutin:create-filmorate-episodes_comments-table
--comment create table filmorate.episodes_comments
create table filmorate.episodes_comments
(
    id         serial primary key,
    episode_id integer not null,
    comment_id integer not null
);
--rollback drop table filmorate.episodes_comments;

--changeset v-lyutin:add-filmorate-episodes_comments-table-constraints
--comment add constraints to filmorate.episodes_comments table
alter table filmorate.episodes_comments
    add constraint episodes_comments__episode__fk
        foreign key (episode_id) references filmorate.episodes (id);

alter table filmorate.episodes_comments
    add constraint episodes_comments__comment__fk
        foreign key (comment_id) references filmorate.comments (id) ON DELETE CASCADE;
--rollback alter table filmorate.episodes_comments drop constraint episodes_comments__episode__fk;
--rollback alter table filmorate.episodes_comments drop constraint episodes_comments__comment__fk;

--changeset v-lyutin:create-filmorate-comment_likes-table
--comment create table filmorate.comment_likes
create table filmorate.comment_likes
(
    comment_id      integer not null,
    user_profile_id integer not null
);
--rollback drop table filmorate.comment_likes;

--changeset v-lyutin:add-comment_likes-table-constraints
--comment add constraints to comment_likes
alter table filmorate.comment_likes
    add constraint comment_likes__user_profile_fk
        foreign key (user_profile_id) references filmorate.user_profiles (id);

alter table filmorate.comment_likes
    add constraint comment_likes__comment_fk
        foreign key (comment_id) references filmorate.comments (id) ON DELETE CASCADE;

alter table filmorate.comment_likes
    add constraint comment_likes_unique
        unique (comment_id, user_profile_id);
--rollback alter table filmorate.comment_likes drop constraint comment_likes__user_profile_fk;
--rollback alter table filmorate.comment_likes drop constraint comment_likes__comment_fk;
--rollback alter table filmorate.comment_likes drop constraint comment_likes_unique;

--changeset v-lyutin:create-filmorate-comment_dislikes-table
--comment create table filmorate.comment_dislikes
create table filmorate.comment_dislikes
(
    comment_id      integer not null,
    user_profile_id integer not null
);
--rollback drop table filmorate.comment_dislikes;

--changeset v-lyutin:add-comment_dislikes-table-constraints
--comment add constraints to comment_dislikes
alter table filmorate.comment_dislikes
    add constraint comment_dislikes__user_profile_fk
        foreign key (user_profile_id) references filmorate.user_profiles (id);

alter table filmorate.comment_dislikes
    add constraint comment_dislikes__comment_fk
        foreign key (comment_id) references filmorate.comments (id) ON DELETE CASCADE;

alter table filmorate.comment_dislikes
    add constraint comment_dislikes_unique
        unique (comment_id, user_profile_id);
--rollback alter table filmorate.comment_dislikes drop constraint comment_dislikes__user_profile_fk;
--rollback alter table filmorate.comment_dislikes drop constraint comment_dislikes__comment_fk;
--rollback alter table filmorate.comment_dislikes drop constraint comment_dislikes_unique;