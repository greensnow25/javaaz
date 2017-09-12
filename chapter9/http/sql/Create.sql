CREATE TABLE users (
  id SERIAL UNIQUE ,
  login VARCHAR(50) UNIQUE ,
  e_mail VARCHAR(100) UNIQUE ,
  crete_date TIMESTAMP DEFAULT now()
);