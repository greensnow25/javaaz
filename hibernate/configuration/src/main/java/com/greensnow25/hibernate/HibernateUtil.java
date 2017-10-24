package com.greensnow25.hibernate;

import com.greensnow25.hibernate.SingletonFactory;
import com.greensnow25.hibernate.commad.Begin;
import com.greensnow25.hibernate.commad.Commit;
import com.greensnow25.hibernate.commad.Rollback;
import com.greensnow25.hibernate.commad.TransactionActions;
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
        this.sessionFactory = SingletonFactory.getSingleton();
    }

    public Integer addItem(String desc, boolean done) {
        Transaction transaction = null;
        Integer id = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            new Begin(new TransactionActions(transaction)).execute();
            Item item = new Item(desc, new Timestamp(System.currentTimeMillis()), done);
            id = (Integer) session.save(item);
            new Commit(new TransactionActions(transaction)).execute();
        } catch (HibernateException e) {
            if (transaction != null) {
                new Rollback(new TransactionActions(transaction)).execute();
                sessionFactory.close();
            }
            e.printStackTrace();
        }
        return id;
    }

    public List<E> getAllItems() {
        Transaction transaction = null;
        List<E> list = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            new Begin(new TransactionActions(transaction)).execute();
            list = session.createQuery("FROM com.greensnow25.model.Item").list();
            new Commit(new TransactionActions(transaction)).execute();
        }
        return list;
    }
}
