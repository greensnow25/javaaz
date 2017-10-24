package com.greensnow25.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Public class SingletonFactory.
 *
 * @author greensnow25.
 * @version 1.
 * @since 24.10.2017.
 */
public class SingletonFactory {

    private SingletonFactory() {
    }

    private static class FactoryHelper {
        private static SessionFactory INSTANCE = new Configuration()
                .configure("com/greensnow25/hibernate.cfg.xml")
                .addResource("com/greensnow25/model/Item.hbm.xml")
                .buildSessionFactory();
    }

    public static SessionFactory getSingleton() {
        return FactoryHelper.INSTANCE;
    }

}
