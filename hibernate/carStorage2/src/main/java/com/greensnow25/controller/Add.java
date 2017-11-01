package com.greensnow25.controller;

import com.greensnow25.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

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

            Body body = new Body("track");
            //body.getCars().add(car1);
            //body.setId(1);
            Transmission transmission = new Transmission("mex");
            //transmission.getCars().add(car1);
            //transmission.setId(1);

            Engine engine = new Engine("V4");
            //engine.getCars().add(car1);
            //engine.setId(1);

           // User u = new User("qqq");
            //u.getCars().add(car1);
            //u.setId(1);
          //  Car car1 = new Car("22", body, transmission, engine, u,233 );

//            Set<Car> carSet = new HashSet<>();
//            carSet.add(car);
//
//            body.setCars(carSet);
//            transmission.setCars(carSet);
//            engine.setCars(carSet);
//            u.setCars(carSet);

            session.save(body);
            session.save(transmission);
            session.save(engine);
         //   session.save(u);
           // session.save(car1);
            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }
}
