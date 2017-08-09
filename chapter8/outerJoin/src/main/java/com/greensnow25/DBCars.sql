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
  "user"      INTEGER,
  car_name    VARCHAR(100),
  body        INTEGER,
  engine      INTEGER,
  transmition INTEGER,
  PRIMARY KEY ("user", car_name, engine, body, transmition),
  FOREIGN KEY (body) REFERENCES car.body_car,
  FOREIGN KEY (engine) REFERENCES car.engine,
  FOREIGN KEY (transmition) REFERENCES car.tansmition,
  FOREIGN KEY ("user") REFERENCES public.users (id)

);



INSERT  INTO car.engine (name_engine) VALUES ('V6');
INSERT  INTO car.engine (name_engine) VALUES ('V8');
INSERT  INTO car.engine (name_engine) VALUES ('V12');



INSERT  INTO car.tansmition(name_transmition) VALUES ('Mechanical transmission');
INSERT  INTO car.tansmition(name_transmition) VALUES ('Automatic transmission');
INSERT  INTO car.tansmition(name_transmition) VALUES ('Robot transmission');


INSERT INTO car.body_car(name_body) VALUES ('Light');
INSERT INTO car.body_car(name_body) VALUES ('Heavy');
INSERT INTO car.body_car(name_body) VALUES ('Super heavy');



INSERT INTO car.car("user", car_name, body, engine, transmition) VALUES (
  (SELECT u.id FROM public.users AS u WHERE user_name ='Tom'),
  'family car',
  (SELECT b.id_car_body FROM car.body_car as b WHERE b.name_body ='Heavy'),
  (SELECT e.id_car_engine FROM car.engine as e WHERE e.name_engine ='V8'),
  (SELECT  t.id_car_transmit FROM car.tansmition as t WHERE t.name_transmition = 'Robot transmission'));
