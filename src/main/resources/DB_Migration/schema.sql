drop table if exists employees;

create table employees
(
    id         INT NOT NULL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    position   VARCHAR(50) NOT NULL
);

drop table if exists interns;

create table interns
(
    id            INT         NOT NULL PRIMARY KEY,
    first_name    VARCHAR(50) NOT NULL,
    last_name     VARCHAR(50) NOT NULL,
    date_of_birth DATE        NOT NULL,
    hobby         TEXT
);