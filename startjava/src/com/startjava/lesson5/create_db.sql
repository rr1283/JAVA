create database jaegers;
create schema jaegers;
--drop table jaegers.jaegers;
create table jaegers.jaegers
(
    id serial not null,
    modelname text,
    mark      text,
    height    numeric,
    weight    numeric,
    status    text,
    origin    text,
    launch    date,
    kaijukill integer,
    primary key (id)
)
    tablespace pg_default;
alter table if exists jaegers.jaegers
    owner to postgres;