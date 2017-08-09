DROP TABLE car.car;
DROP TABLE car.tansmition;
DROP TABLE car.engine;
DROP TABLE car.body_car;

-- create schema car;
-- DROP SCHEMA  car CASCADE ;
-- DROP SCHEMA  cars CASCADE ;
CREATE TABLE car.body_car (
  id_car_body SERIAL PRIMARY KEY,
  name_body   VARCHAR(100)
);

CREATE TABLE car.tansmition (
  id_car_transmit  SERIAL PRIMARY KEY,
  name_transmition VARCHAR(100)
);
CREATE TABLE car.engine (
  id_car_engine SERIAL PRIMARY KEY,
  name_engine   VARCHAR(100)
);
CREATE TABLE car.car (
  id_car      SERIAL PRIMARY KEY,
  "user"        INTEGER,
  car_name    VARCHAR(100),
  body        INTEGER,
  engine      INTEGER,
  transmition INTEGER,
  FOREIGN KEY (body) REFERENCES car.body_car,
  FOREIGN KEY (engine) REFERENCES car.engine,
  FOREIGN KEY (transmition) REFERENCES car.tansmition,
  FOREIGN KEY ("user")REFERENCES public.users(id)

);
