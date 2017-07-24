DROP TABLE regions;
CREATE TABLE regions (
  id     SERIAL PRIMARY KEY,
  name   VARCHAR(255) NOT NULL UNIQUE,
  active BOOLEAN      NOT NULL DEFAULT TRUE
);
DROP TABLE citys;
CREATE TABLE citys (
  id         SERIAL PRIMARY KEY,
  name       VARCHAR(255) NOT NULL UNIQUE,
  regions_id INTEGER      NOT NULL,
  active     BOOLEAN      NOT NULL DEFAULT TRUE,
  FOREIGN KEY (regions_id) REFERENCES regions (id)
);

