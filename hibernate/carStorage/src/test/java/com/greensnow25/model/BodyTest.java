package com.greensnow25.model;

import com.greensnow25.controller.Add;
import com.greensnow25.hibernate.SingletonSessionFactory;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Public class BodyTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 23.10.2017.
 */
public class BodyTest {
    private SessionFactory factory;

    public void prepareFactory() {
        this.factory = SingletonSessionFactory.getInstance();
    }

    // @Before
    public void beforeTheTest() {
        prepareFactory();
    }

    @Test
    public void whenThen() {
        prepareFactory();
        Add add = new Add(factory);
         Car car = new Car("1", new Body("track"), new Transmission("auto"), new Engine("V8"), new User("alex"));
         // Car car = new Car();
        add.execute(car);
    }


}