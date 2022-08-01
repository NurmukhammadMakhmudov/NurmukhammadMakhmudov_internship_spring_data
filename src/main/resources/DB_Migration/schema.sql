drop table if exists employees;
drop table if exists interns;
drop table if exists users;
drop table if exists roles;

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



create table roles
(
    id   INT         NOT NULL PRIMARY KEY,
    role VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL
);



create table users
(
    id         INT          NOT NULL PRIMARY KEY,
    role_id    INT REFERENCES roles (id),
    first_name VARCHAR(50)  NOT NULL,
    last_name  VARCHAR(50)  NOT NULL,
    email      VARCHAR(255) NOT NULL,
    pass_word  VARCHAR(255)  NOT NULL,
    isactive   BOOLEAN

);

