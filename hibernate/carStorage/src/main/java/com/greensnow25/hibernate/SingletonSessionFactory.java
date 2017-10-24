package com.greensnow25.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Public class SingletonSessionFactory.
 *
 * @author greensnow25.
 * @version 1.
 * @since 24.10.2017.
 */
public class SingletonSessionFactory {
    private SingletonSessionFactory() {
    }

    private static class SingletonHelper {
        private static SessionFactory INSTANCE = new Configuration()
                .configure("hibernate.cfg.xml")
                .addResource("com/greensnow25/model/Body.hbm.xml")
                .addResource("com/greensnow25/model/Car.hbm.xml")
                .addResource("com/greensnow25/model/Engine.hbm.xml")
                .addResource("com/greensnow25/model/Transmission.hbm.xml")
                .addResource("com/greensnow25/model/User.hbm.xml")
                .buildSessionFactory();
    }

    public static SessionFactory getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
