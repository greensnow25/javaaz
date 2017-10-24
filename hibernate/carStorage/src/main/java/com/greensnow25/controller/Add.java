package com.greensnow25.controller;

import com.greensnow25.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Public class Add.
 *
 * @author greensnow25.
 * @version 1.
 * @since 24.10.2017.
 */
public class Add implements Action {
    private SessionFactory factory;

    public Add(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void execute(Car car) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            //Car car = new Car("1", new Body("track"), new Transmission("auto"), new Engine("V8"), new User("alex"));
            session.saveOrUpdate(car);
            transaction.commit();

        }

    }
}
