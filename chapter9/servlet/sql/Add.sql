CREATE TABLE servlet.public.role (
  id   SERIAL PRIMARY KEY,
  role VARCHAR(10)
);
CREATE TABLE servlet.public.visitors (
  id       SERIAL UNIQUE,
  login    VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(10)        NOT NULL
);

CREATE TABLE servlet.public.roleBase (
  id_roleBase SERIAL,
  user_id     INTEGER,
  role        INTEGER,
  FOREIGN KEY (role) REFERENCES role (id),
  FOREIGN KEY (user_id) REFERENCES visitors (id)
);

INSERT INTO servlet.public.role (role) VALUES ('admin');
INSERT INTO servlet.public.role (role) VALUES ('moderator');
INSERT INTO servlet.public.role (role) VALUES ('user');


INSERT INTO servlet.public.visitors (login, password) VALUES ('ADMIN', 'ADMIN');
INSERT INTO servlet.public.visitors (login, password) VALUES ('MOD', 'MOD');
INSERT INTO servlet.public.visitors (login, password) VALUES ('USER', 'USER');
INSERT INTO servlet.public.visitors (login, password) VALUES ('login', 'psw');