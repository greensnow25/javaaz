CREATE TABLE item (
  id      SERIAL PRIMARY KEY,
  description    TEXT,
  created TIMESTAMP,
  done    BOOLEAN NOT NULL DEFAULT FALSE
);