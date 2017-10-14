package com.greensnow25.repository;

/**
 * Public class SearchUserByAddress.
 *
 * @author greensnow25.
 * @version 1.
 * @since 13.10.2017.
 */
public class SearchUserByAddress implements SqlSpecification {

    @Override
    public String toSQLQuery() {

        return String.format("SELECT U.name, A.country, A.city, R.role, M.type\n" +
                "FROM servlet.controltask.user AS U\n" +
                "  INNER JOIN servlet.controltask.address AS A ON U.id_user = A.id_address\n" +
                "  INNER JOIN servlet.controltask.role AS R ON U.user_role = R.id_role\n" +
                "  INNER JOIN servlet.controltask.user_musictype AS UM ON U.id_user = UM.id_user\n" +
                "  INNER JOIN servlet.controltask.musictype AS M ON UM.id_musictype = M.id_musictype\n" +
                "WHERE city = 'Kiev'\n" +
                "\n");
    }
}
