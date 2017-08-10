
-- The query displays all the information about the car.
SELECT
  D.car_name,
  users.user_name,
  D.name_body,
  D.name_transmition,
  D.name_engine
FROM ((((SELECT *
         FROM car.car AS carA) AS A
  INNER JOIN car.tansmition AS tr ON A.transmition = tr.id_car_transmit) AS B
  INNER JOIN car.engine AS en ON B.engine = en.id_car_engine) AS C
  INNER JOIN car.body_car AS bc ON C.body = bc.id_car_body) AS D
  INNER JOIN public.users as users on users.id = D.user;

--The request displays all information about unused spare parts.
SELECT
  tr.name_transmition as "unused part"
FROM car.car AS carA
RIGHT JOIN car.tansmition AS tr ON carA.transmition = tr.id_car_transmit
WHERE carA.transmition ISNULL
UNION
SELECT
  e.name_engine as "unused part"
FROM car.car AS carA
  RIGHT JOIN car.engine AS e ON carA.engine = e.id_car_engine
WHERE carA.engine ISNULL
UNION
SELECT
  bc.name_body as "unused part"
FROM car.car AS carA
  RIGHT JOIN car.body_car AS bc ON carA.body = bc.id_car_body
WHERE carA.body ISNULL