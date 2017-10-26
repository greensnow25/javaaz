
-- add car engine type.
INSERT  INTO hibernate.car_storage.engine (name_engine) VALUES ('V6');
INSERT  INTO hibernate.car_storage.engine (name_engine) VALUES ('V8');
INSERT  INTO hibernate.car_storage.engine (name_engine) VALUES ('V12');

-- add car transmition type.
INSERT  INTO hibernate.car_storage.transmission(name_transmition) VALUES ('Mechanical transmission');
INSERT  INTO hibernate.car_storage.transmission(name_transmition) VALUES ('Automatic transmission');
INSERT  INTO hibernate.car_storage.transmission(name_transmition) VALUES ('Robot transmission');

-- add body_car type.
INSERT INTO hibernate.car_storage.body_car(name_body) VALUES ('Light');
INSERT INTO hibernate.car_storage.body_car(name_body) VALUES ('Heavy');
INSERT INTO hibernate.car_storage.body_car(name_body) VALUES ('Super heavy');

--insert into cars(create a new car).
INSERT INTO hibernate.car_storage.car(price, car_name, body_id, engine_id, transmition_id) VALUES ( 1000,
--   (SELECT u.id FROM hibernate.car_storage.user AS u WHERE user_name ='Tom'),
  'family car',
  (SELECT b.id_car_body FROM hibernate.car_storage.body_car as b WHERE b.name_body ='Heavy'),
  (SELECT e.id_car_engine FROM hibernate.car_storage.engine as e WHERE e.name_engine ='V8'),
  (SELECT  t.id_car_transmit FROM hibernate.car_storage.transmission as t WHERE t.name_transmition = 'Robot transmission'));

--insert into cars(create a new car).
INSERT INTO hibernate.car_storage.car(price, car_name, body_id, engine_id, transmition_id) VALUES (2000,
--   (SELECT u.id FROM hibernate.car_storage.user AS u WHERE user_name ='Sara'),
  'sport car',
  (SELECT b.id_car_body FROM hibernate.car_storage.body_car as b WHERE b.name_body ='Light'),
  (SELECT e.id_car_engine FROM hibernate.car_storage.engine as e WHERE e.name_engine ='V12'),
  (SELECT  t.id_car_transmit FROM hibernate.car_storage.transmission as t WHERE t.name_transmition = 'Mechanical transmission'));

--insert into cars(create a new car).
INSERT INTO hibernate.car_storage.car(price, car_name, body_id, engine_id, transmition_id) VALUES (3000,
--   (SELECT u.id FROM hibernate.car_storage.user AS u WHERE user_name ='Tom'),
  'track',
  (SELECT b.id_car_body FROM hibernate.car_storage.body_car as b WHERE b.name_body ='Super heavy'),
  (SELECT e.id_car_engine FROM hibernate.car_storage.engine as e WHERE e.name_engine ='V12'),
  (SELECT  t.id_car_transmit FROM hibernate.car_storage.transmission as t WHERE t.name_transmition = 'Robot transmission'));
