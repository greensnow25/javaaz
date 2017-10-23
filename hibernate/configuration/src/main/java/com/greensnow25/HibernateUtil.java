package com.greensnow25;

import com.greensnow25.model.Item;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.util.List;

/**
 * Public class HibernateUtil.
 *
 * @param <E> param.
 * @author greensnow25.
 * @version 1.
 * @since 20.10.2017.
 */
public class HibernateUtil<E> {
    /**
     * session factory.
     */
    private SessionFactory sessionFactory;

    public HibernateUtil() {
        Configuration cnf = new Configuration();
        cnf.configure("com/greensnow25/hibernate.cfg.xml");
        cnf.addResource("com/greensnow25/model/Item.hbm.xml");
        sessionFactory = cnf.buildSessionFactory();
    }

    public Integer addItem(String desc, boolean done) {
        Transaction transaction = null;
        Integer id = null;
        try (Session session = sessionFactory.openSession();) {
            transaction = session.beginTransaction();
            Item item = new Item(desc, new Timestamp(System.currentTimeMillis()), done);
            id = (Integer) session.save(item);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
        return id;
    }

    public List<E> getAllItems() {
        Transaction transaction = null;
        List<E> list = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            list = session.createQuery("FROM com.greensnow25.model.Item").list();
            transaction.commit();
        } finally {
            sessionFactory.close();
        }
        return list;
    }
}
