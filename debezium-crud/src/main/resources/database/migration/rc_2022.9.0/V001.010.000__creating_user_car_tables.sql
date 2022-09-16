CREATE TABLE users
(
    id      BIGSERIAL PRIMARY KEY,
    name    TEXT NOT NULL ,
    age     INTEGER NOT NULL
);

CREATE TABLE cars
(
    id      BIGSERIAL PRIMARY KEY,
    name    TEXT NOT NULL ,
    number  INTEGER NOT NULL
);