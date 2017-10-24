
-- add car engine type.
INSERT  INTO car.engine (name_engine) VALUES ('V6');
INSERT  INTO car.engine (name_engine) VALUES ('V8');
INSERT  INTO car.engine (name_engine) VALUES ('V12');

-- add car transmition type.
INSERT  INTO car.tansmition(name_transmition) VALUES ('Mechanical transmission');
INSERT  INTO car.tansmition(name_transmition) VALUES ('Automatic transmission');
INSERT  INTO car.tansmition(name_transmition) VALUES ('Robot transmission');

-- add body_car type.
INSERT INTO car.body_car(name_body) VALUES ('Light');
INSERT INTO car.body_car(name_body) VALUES ('Heavy');
INSERT INTO car.body_car(name_body) VALUES ('Super heavy');

--insert into cars(create a new car).
INSERT INTO car.car("user", car_name, body, engine, transmition) VALUES (
  (SELECT u.id FROM public.users AS u WHERE user_name ='Tom'),
  'family car',
  (SELECT b.id_car_body FROM car.body_car as b WHERE b.name_body ='Heavy'),
  (SELECT e.id_car_engine FROM car.engine as e WHERE e.name_engine ='V8'),
  (SELECT  t.id_car_transmit FROM car.tansmition as t WHERE t.name_transmition = 'Robot transmission'));

--insert into cars(create a new car).
INSERT INTO car.car("user", car_name, body, engine, transmition) VALUES (
  (SELECT u.id FROM public.users AS u WHERE user_name ='Sara'),
  'sport car',
  (SELECT b.id_car_body FROM car.body_car as b WHERE b.name_body ='Light'),
  (SELECT e.id_car_engine FROM car.engine as e WHERE e.name_engine ='V12'),
  (SELECT  t.id_car_transmit FROM car.tansmition as t WHERE t.name_transmition = 'Mechanical transmission'));

--insert into cars(create a new car).
INSERT INTO car.car("user", car_name, body, engine, transmition) VALUES (
  (SELECT u.id FROM public.users AS u WHERE user_name ='Tom'),
  'track',
  (SELECT b.id_car_body FROM car.body_car as b WHERE b.name_body ='Super heavy'),
  (SELECT e.id_car_engine FROM car.engine as e WHERE e.name_engine ='V12'),
  (SELECT  t.id_car_transmit FROM car.tansmition as t WHERE t.name_transmition = 'Robot transmission'));
