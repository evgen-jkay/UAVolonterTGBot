CREATE SCHEMA volunteer;

USE volunteer;

CREATE TABLE user (
	id bigint auto_increment primary key,
    user_name varchar(25),
    first_name varchar(25),
    last_name varchar(50),
    phone bigint unique,
    chat_id bigint unique
);

CREATE TABLE message (
	id bigint auto_increment primary key,
    city varchar(50),
    message text
);