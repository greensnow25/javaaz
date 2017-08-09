-- query displays all information from the table.
select * from users;

-- select users whose id numbers fall in the sample.
select u."id" , u.user_name as name
from users as u
where id in(1,3);

-- select comments from table where id of request are located in interval.
select r.coment
from request as r
where id_request between 1 and 3;
-- query select and displays user_name and him role.
select u.user_name as name, r.role as roole
from users as u inner join user_roles as r
    on u.role_id = r.id;

-- request select user name, his role and comment to request, with help inner join of three tables.
SELECT
  u.user_name AS name,
  r.role      AS roole,
  req.coment  AS comment
FROM users AS u
  INNER JOIN user_roles AS r ON u.role_id = r.id
  INNER JOIN users_request AS ureq ON r.id = ureq.id_request
  INNER JOIN request AS req ON ureq.id_request = req.id_request



