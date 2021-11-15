CREATE TABLE role
(
    id   SERIAL PRIMARY KEY,
    role VARCHAR(16)
);

CREATE TABLE "user"
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(64),
    password VARCHAR(64),
    role_id  SERIAL REFERENCES role (id)
);

CREATE TABLE room
(
    id          SERIAL PRIMARY KEY,
    label       INTEGER,
    has_kitchen BOOLEAN,
    has_bath    BOOLEAN
);

CREATE TABLE reservation
(
    id      SERIAL PRIMARY KEY,
    room_id SERIAL REFERENCES room(id),
    user_id SERIAL REFERENCES "user"(id)
);