-- CREATE SCHEMA controlTask;
DROP TABLE controlTask.user CASCADE ;
CREATE TABLE servlet.controlTask.user (
  id_user   SERIAL PRIMARY KEY,
  name      VARCHAR(50) UNIQUE NOT NULL,
  user_role INTEGER REFERENCES controlTask.role (id_role) DEFAULT 3
);
INSERT INTO controlTask.user (name, user_role) VALUES ('alex', 1);
INSERT INTO controlTask.user (name, user_role) VALUES ('qqq', 2);
INSERT INTO controlTask.user (name, user_role) VALUES ('www', 2);
INSERT INTO controlTask.user (name, user_role) VALUES ('aaa', 3);
INSERT INTO controlTask.user (name, user_role) VALUES ('zzz', 3);

CREATE TABLE servlet.controlTask.role (
  id_role SERIAL PRIMARY KEY,
  role    VARCHAR(20) UNIQUE NOT NULL
);
INSERT INTO controlTask.role (role) VALUES ('ADMIN');
INSERT INTO controlTask.role (role) VALUES ('MODERATOR');
INSERT INTO controlTask.role (role) VALUES ('USER');

CREATE TABLE servlet.controlTask.address (
  id_address SERIAL PRIMARY KEY,
  country    VARCHAR(20) NOT NULL,
  city       VARCHAR(20) NOT NULL
);
INSERT INTO controlTask.address (country, city) VALUES ('Ukraine', 'Kiev');
INSERT INTO controlTask.address (country, city) VALUES ('Ukraine', 'Kiev');
INSERT INTO controlTask.address (country, city) VALUES ('Ukraine', 'Kiev');
INSERT INTO controlTask.address (country, city) VALUES ('Ukraine', 'Kiev');
INSERT INTO controlTask.address (country, city) VALUES ('Ukraine', 'Kiev');

CREATE TABLE servlet.controlTask.musicType (
  id_musicType SERIAL PRIMARY KEY,
  type         VARCHAR(20) UNIQUE NOT NULL
);
INSERT INTO controlTask.musicType (type) VALUES ('POCK');
INSERT INTO controlTask.musicType (type) VALUES ('POP');
INSERT INTO controlTask.musicType (type) VALUES ('RAP');
INSERT INTO controlTask.musicType (type) VALUES ('CLUB');


CREATE TABLE servlet.controlTask.user_musicType (
  id_user      INTEGER REFERENCES controlTask.user (id_user),
  id_musicType INTEGER REFERENCES controlTask.musicType (id_musicType),
  PRIMARY KEY (id_user, id_musicType)
);
INSERT INTO controlTask.user_musicType (id_user, id_musicType) VALUES (1, 2);
INSERT INTO controlTask.user_musicType (id_user, id_musicType) VALUES (1, 1);
INSERT INTO controlTask.user_musicType (id_user, id_musicType) VALUES (2, 2);
INSERT INTO controlTask.user_musicType (id_user, id_musicType) VALUES (2, 1);
INSERT INTO controlTask.user_musicType (id_user, id_musicType) VALUES (3, 2);
INSERT INTO controlTask.user_musicType (id_user, id_musicType) VALUES (4, 2);
INSERT INTO controlTask.user_musicType (id_user, id_musicType) VALUES (5, 2);
