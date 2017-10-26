CREATE SCHEMA car_storage;
--create user.
CREATE TABLE car_storage.user (
  id       SERIAL PRIMARY KEY,
  user_name VARCHAR(50)
);

--create table body_car.
CREATE TABLE car_storage.body_car (
  id_car_body SERIAL PRIMARY KEY,
  name_body   VARCHAR(100)
);

--create table transmission.
CREATE TABLE car_storage.transmission (
  id_car_transmit  SERIAL PRIMARY KEY,
  name_transmition VARCHAR(100)
);

--create table  engine.
CREATE TABLE car_storage.engine (
  id_car_engine SERIAL PRIMARY KEY,
  name_engine   VARCHAR(100)
);

--create table car.
CREATE TABLE car_storage.car (
  id             SERIAL,
  user_id        INTEGER,
  car_name       VARCHAR(100),
  body_id        INTEGER,
  engine_id      INTEGER,
  price          INTEGER NOT NULL DEFAULT 1000,
  transmition_id INTEGER,
  PRIMARY KEY (user_id, car_name, engine_id, body_id, transmition_id),
  FOREIGN KEY (body_id) REFERENCES car_storage.body_car,
  FOREIGN KEY (engine_id) REFERENCES car_storage.engine,
  FOREIGN KEY (transmition_id) REFERENCES car_storage.transmission,
  FOREIGN KEY (user_id) REFERENCES car_storage.user
);

                                                                                                        =
                                                                                                        'Robot transmission'));
 CREATE TABLE car_storage.image (
   id    SERIAL PRIMARY KEY,
   name  VARCHAR(100) NOT NULL,
   image BYTEA        NOT NULL
 )