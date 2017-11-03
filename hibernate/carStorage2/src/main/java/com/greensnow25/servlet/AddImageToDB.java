package com.greensnow25.servlet;

import com.greensnow25.hibernate.SingletonSessionFactory;
import com.greensnow25.model.Image;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Public class AddImageToDB.
 *
 * @author greensnow25.
 * @version 1.
 * @since 25.10.2017.
 */
@WebServlet(urlPatterns = "/wiev/addImage")
public class AddImageToDB extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hibernate save image into database");
        SessionFactory factory = SingletonSessionFactory.getInstance();

        try (Session session = factory.openSession()) {
            String name = null;
            session.beginTransaction();
//            File f = new File();
            //save image into database
            File file = new File(req.getParameter("image"));
            name = file.getName();
            byte[] bFile = new byte[(int) file.length()];

            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                //convert file into array of bytes
                fileInputStream.read(bFile);
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Image avatar = new Image();
            avatar.setImage(bFile);
            avatar.setName(name);

            session.save(avatar);

//            //Get image from database
//            Avatar avatar2 = (Avatar) session.get(Avatar.class, avatar.getAvatarId());
//            byte[] bAvatar = avatar2.getImage();
//
//            try {
//                FileOutputStream fos = new FileOutputStream("C:\\test.gif");
//                fos.write(bAvatar);
//                fos.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

            session.getTransaction().commit();
        }
    }

    public static void main(String[] args) throws ServletException, IOException {
        AddImageToDB addImageToDB = new AddImageToDB();
        addImageToDB.doPost(null, null);
    }
}
