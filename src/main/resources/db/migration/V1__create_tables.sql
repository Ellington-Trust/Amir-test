-- V1__Initial_setup.sql

create table if not exists user (
    uid int not null primary key,
    first_name  varchar(255),
    last_name   varchar(255),
    age         int,
    email       varchar(255),
    address     varchar(255)
    );

create table if not exists article (
    article_id int not null primary key,
    title       varchar(255),
    price       int,
    company     varchar(255),
    count       int,
    category_id int
    );

create table if not exists my_order (
    order_id int not null primary key,
    article_id int not null,
    customer_id int not null,
    count int not null,
    order_date datetime
    );

