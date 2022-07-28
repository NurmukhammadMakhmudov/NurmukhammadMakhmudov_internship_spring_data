drop table if exists employees;
drop table if exists interns;
drop table if exists users;
drop table if exists role;

create table employees
(
    id         INT         NOT NULL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    position   VARCHAR(50) NOT NULL
);



create table interns
(
    id            INT         NOT NULL PRIMARY KEY,
    first_name    VARCHAR(50) NOT NULL,
    last_name     VARCHAR(50) NOT NULL,
    date_of_birth DATE        NOT NULL,
    hobby         VARCHAR(150)
);



create table "role"
(
    id   INT         NOT NULL PRIMARY KEY,
    role VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL
);



create table users
(
    id         INT          NOT NULL PRIMARY KEY,
    role_id    INT REFERENCES role (id),
    first_name VARCHAR(50)  NOT NULL,
    last_name  VARCHAR(50)  NOT NULL,
    email      VARCHAR(150) NOT NULL,
    pass_word  VARCHAR(50)  NOT NULL,
    isactive   BOOLEAN

);

