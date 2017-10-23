package com.greensnow25.model.prepare;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;

/**
 * Public class Prepare.
 *
 * @author greensnow25.
 * @version 1.
 * @since 23.10.2017.
 */
public class Prepare {

    protected SessionFactory sessionFactory;

    public void createInstance() {
        Configuration configuration = new Configuration();
        sessionFactory = configuration.configure().addResource("com/greensnow25/model/Body.hbm.xml")
                .addResource("com/greensnow25/model/Car.hbm.xml")
                .addResource("com/greensnow25/model/Engine.hbm.xml")
                .addResource("com/greensnow25/model/Transmission.hbm.xml")
                .addResource("com/greensnow25/model/User.hbm.xml")
                .buildSessionFactory();
    }

    @Before
    public void beforeTheTest() {

    }
}