package com.greensnow25.servlet;

import com.google.gson.Gson;
import com.greensnow25.hibernate.SingletonSessionFactory;
import com.greensnow25.model.Image;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;

/**
 * Public class GetImage.
 *
 * @author greensnow25.
 * @version 1.
 * @since 26.10.2017.
 */
@WebServlet(urlPatterns = "/getImage")
public class GetImage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=UTF-8");
        SessionFactory factory = SingletonSessionFactory.getInstance();
        Transaction transaction = null;
        try (Session session = factory.openSession();) {
            transaction = session.getTransaction();
            transaction.begin();
            Query query = session.createQuery("from com.greensnow25.model.Image as I where I.id =4");
            query.setReadOnly(true);

            List<Image> list = query.list();
            Image image = list.get(0);
            byte[]arr = image.getImage();
            String json = new Gson().toJson(arr);
            resp.getWriter().write(json);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }


    public static void main(String[] args) {
        System.out.println("Hibernate save image into database");
        Session session = SingletonSessionFactory.getInstance().openSession();

        session.beginTransaction();

        //save image into database
        File file = new File("E:\\car1.jpg");
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
        avatar.setName("test");
        avatar.setImage(bFile);

        session.save(avatar);

        //Get image from database
        Image avatar2 = (Image) session.get(Image.class, avatar.getId());
        byte[] bAvatar = avatar2.getImage();

        try {
            FileOutputStream fos = new FileOutputStream("E:\\test.gif");
            fos.write(bAvatar);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.getTransaction().commit();
    }
}
