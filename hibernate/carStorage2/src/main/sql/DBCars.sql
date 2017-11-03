CREATE SCHEMA IF NOT EXISTS car_storage;
--create user.
CREATE TABLE IF NOT EXISTS car_storage.user (
  id        SERIAL PRIMARY KEY,
  user_name VARCHAR(50),
  password
);

--create table body_car.
CREATE TABLE IF NOT EXISTS car_storage.body_car (
  id_car_body SERIAL PRIMARY KEY,
  name_body   VARCHAR(100)
);

--create table transmission.
CREATE TABLE IF NOT EXISTS car_storage.transmission (
  id_car_transmit  SERIAL PRIMARY KEY,
  name_transmition VARCHAR(100)
);

--create table  engine.
CREATE TABLE IF NOT EXISTS car_storage.engine (
  id_car_engine SERIAL PRIMARY KEY,
  name_engine   VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS car_storage.brand (
  id_brand   SERIAL PRIMARY KEY,
  name_brand VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS car_storage.image (
  id    SERIAL PRIMARY KEY,
  name  VARCHAR(100) NOT NULL,
  image BYTEA        NOT NULL
);
--create table car.
CREATE TABLE IF NOT EXISTS car_storage.car (
  id             SERIAL,
  user_id        INTEGER,
  car_name       VARCHAR(100),
  body_id        INTEGER,
  engine_id      INTEGER,
  price          INTEGER NOT NULL DEFAULT 1000,
  transmition_id INTEGER,
  brand_id       INTEGER,
  model_id       INTEGER,
  PRIMARY KEY (user_id, car_name, engine_id, body_id, transmition_id),
  FOREIGN KEY (body_id) REFERENCES car_storage.body_car,
  FOREIGN KEY (engine_id) REFERENCES car_storage.engine,
  FOREIGN KEY (transmition_id) REFERENCES car_storage.transmission,
  FOREIGN KEY (user_id) REFERENCES car_storage.user,
  FOREIGN KEY (brand_id) REFERENCES car_storage.brand,
  FOREIGN KEY (model_id) REFERENCES car_storage.model
);
CREATE TABLE IF NOT EXISTS car_storage.order (
  order_id   SERIAL PRIMARY KEY,
  car_id     INTEGER NOT NULL,
  name_order VARCHAR(100),
  sold       BOOLEAN DEFAULT FALSE,
  FOREIGN KEY (car_id) REFERENCES car_storage.car
);


CREATE TABLE IF NOT EXISTS car_storage.order_image (
  id       SERIAL PRIMARY KEY,
  orer_id  INTEGER NOT NULL,
  image_id INTEGER NOT NULL,
  UNIQUE (orer_id, image_id)

)



CREATE TABLE IF NOT EXISTS car_storage.model (
  model_id SERIAL PRIMARY KEY ,
  brand_name VARCHAR(20),
  model_name VARCHAR(30),
  UNIQUE (brand_name,model_name)
)