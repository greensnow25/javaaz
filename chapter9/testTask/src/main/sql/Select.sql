SELECT U.name, A.country, A.city, R.role, M.type
FROM servlet.controltask.user AS U
  INNER JOIN servlet.controltask.address AS A ON U.id_user = A.id_address
  INNER JOIN servlet.controltask.role AS R ON U.user_role = R.id_role
  INNER JOIN servlet.controltask.user_musictype AS UM ON U.id_user = UM.id_user
  INNER JOIN servlet.controltask.musictype AS M ON UM.id_musictype = M.id_musictype
WHERE city = 'Kiev'

