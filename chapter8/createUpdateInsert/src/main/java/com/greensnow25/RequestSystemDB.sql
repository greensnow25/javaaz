-- drop schema if exist.
DROP SCHEMA public CASCADE;
--create new public.
CREATE SCHEMA public;
--create enum consisting of user roles.
CREATE TYPE USER_ROLE AS ENUM ('Admin', 'User', 'Moderator');
--create table user roles.
CREATE TABLE user_roles (
  id   SERIAL PRIMARY KEY,
  role USER_ROLE DEFAULT 'User'UNIQUE
);
-- Insert data into the table.
INSERT INTO user_roles (role) VALUES ('User');
INSERT INTO user_roles (role) VALUES ('Admin');
INSERT INTO user_roles (role) VALUES ('Moderator');
--create enum.
CREATE TYPE RIGHTS AS ENUM ('Read only', 'Read and write', 'Write');
--create table consisting of user rights.
CREATE TABLE user_rights (
  id_rights       SERIAL PRIMARY KEY,
  user_right_enum RIGHTS UNIQUE
);
--insert data.
INSERT INTO user_rights (user_right_enum) VALUES ('Read only');
INSERT INTO user_rights (user_right_enum) VALUES ('Read and write');
INSERT INTO user_rights (user_right_enum) VALUES ('Write');
-- create file storage.
CREATE TABLE file_storage (
  id_file   SERIAL PRIMARY KEY,
  file_name VARCHAR(100) NOT NULL UNIQUE
);
-- insert to the file storage.
INSERT INTO file_storage (file_name) VALUES ('test.txt');
INSERT INTO file_storage (file_name) VALUES ('test1.txt');
INSERT INTO file_storage (file_name) VALUES ('test2.txt');
INSERT INTO file_storage (file_name) VALUES ('test3.txt');
-- create enum.
CREATE TYPE STATE AS ENUM ('DONE', 'IN PROCESSING', 'EXPECT');
--create table of request.
CREATE TABLE request (
  id_request    SERIAL PRIMARY KEY,
  coment        TEXT NOT NULL,
  state_request STATE,
  file_name     INTEGER REFERENCES file_storage
);
--insert data.
INSERT INTO request (coment, state_request, file_name) VALUES ('TODO SOME...', 'EXPECT', 1);
INSERT INTO request (coment, state_request, file_name) VALUES ('TODO SOME1...', 'EXPECT', 2);
INSERT INTO request (coment, state_request, file_name) VALUES ('TODO SOME2...', 'EXPECT', 3);
--create table user.
CREATE TABLE users (
  id         SERIAL PRIMARY KEY,
  user_name  VARCHAR(20) NOT NULL UNIQUE,
  role_id    INTEGER REFERENCES user_roles,
  user_right INTEGER REFERENCES user_rights
);
--insert data.
INSERT INTO users (user_name, role_id, user_right) VALUES ('Nick', 1, 1);
INSERT INTO users (user_name, role_id, user_right) VALUES ('Sara', 2, 1);
INSERT INTO users (user_name, role_id, user_right) VALUES ('Tom', 2, 2);
--create table relations many to many.
CREATE TABLE users_request (
  id_user    INTEGER,
  id_request INTEGER,
  PRIMARY KEY (id_user, id_request),
  FOREIGN KEY (id_user) REFERENCES users,
  FOREIGN KEY (id_request) REFERENCES request
);
-- insert data.
INSERT INTO users_request VALUES (1, 1);
INSERT INTO users_request VALUES (1, 2);
INSERT INTO users_request VALUES (1, 3);
INSERT INTO users_request VALUES (2, 3);
--check table.
SELECT user_name
FROM users
  INNER JOIN users_request
    ON users.id = users_request.id_user
GROUP BY user_name;




