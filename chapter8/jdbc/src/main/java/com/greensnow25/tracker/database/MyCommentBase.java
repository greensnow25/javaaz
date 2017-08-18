package com.greensnow25.tracker.database;

import com.greensnow25.tracker.model.Comment;
import com.greensnow25.tracker.model.InterfaceComment;

import java.sql.*;

/**
 * Public class myCommentBase.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.08.2017.
 */
public class MyCommentBase implements InterfaceComment {

    private Connection connection = null;
    private PreparedStatement st;

    public MyCommentBase() {
        this.connection = new ConnectionToMyBase().getConnection();
    }

    @Override
    public String[] addComment(String comment, String userName) {

        try {
            st = connection.prepareStatement("INSERT INTO tracker.comments (comment,id_user)VALUES (?, (SELECT A.id_user  FROM tracker.items AS A WHERE A.user_name = ?))");
            st.setString(1, comment);
            st.setString(2, userName);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new String[0];
    }

    @Override
    public String[] show(String userName) {
        try {

            st = connection.prepareStatement("SELECT A.comment FROM tracker.comments AS A INNER JOIN tracker.items AS B ON B.user_name =?AND A.id_user = B.id_user");
            st.setString(1,userName);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()){
                System.out.println( resultSet.getString("comment"));
                System.out.printf("%s%s",
                        resultSet.getString("comment"),
                        System.getProperty("line.separator"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new String[0];
    }
}
