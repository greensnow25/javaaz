--create table body_car.
CREATE TABLE car.body_car (
  id_car_body SERIAL PRIMARY KEY,
  name_body   VARCHAR(100)
);

--create table transmition.
CREATE TABLE car.tansmition (
  id_car_transmit  SERIAL PRIMARY KEY,
  name_transmition VARCHAR(100)
);

--create table  engine.
CREATE TABLE car.engine (
  id_car_engine SERIAL PRIMARY KEY,
  name_engine   VARCHAR(100)
);

--create table car.
CREATE TABLE car.car (
  user      INTEGER,
  car_name    VARCHAR(100),
  body        INTEGER,
  engine      INTEGER,
  transmition INTEGER,
  PRIMARY KEY ("user", car_name, engine, body, transmition),
  FOREIGN KEY (body) REFERENCES car.body_car,
  FOREIGN KEY (engine) REFERENCES car.engine,
  FOREIGN KEY (transmition) REFERENCES car.tansmition,
  FOREIGN KEY (user) REFERENCES public.users (id)
);
