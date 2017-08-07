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

WITH A AS (SELECT  maker, model
FROM Product
WHERE type = 'Printer'
AND maker IN(SELECT P.maker FROM Product P WHERE P.type ='PC' ))

SELECT A.maker AVG(PC.hd) AS PRICE
FROM A JOIN PC
ON A.model = PC.model
GROUP BY A.maker
