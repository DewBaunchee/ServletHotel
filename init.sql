DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS "user";
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS room;

CREATE TABLE role
(
    id   SERIAL PRIMARY KEY,
    role VARCHAR(16) UNIQUE NOT NULL
);

INSERT INTO role(role)
VALUES ('ADMIN'),
       ('USER');

CREATE TABLE "user"
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(64) UNIQUE NOT NULL,
    password VARCHAR(64)        NOT NULL,
    role_id  SERIAL             NOT NULL REFERENCES role (id)
);

CREATE TABLE room
(
    id          SERIAL PRIMARY KEY,
    label       INTEGER NOT NULL,
    has_kitchen BOOLEAN,
    has_bath    BOOLEAN
);

CREATE TABLE reservation
(
    id      SERIAL PRIMARY KEY,
    room_id SERIAL NOT NULL REFERENCES room (id),
    user_id SERIAL NOT NULL REFERENCES "user" (id)
);