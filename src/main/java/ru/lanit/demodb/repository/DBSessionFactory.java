package ru.lanit.demodb.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class DBSessionFactory {

    private static SessionFactory ourSessionFactory = null;

    static SessionFactory getInstance() {
        if (ourSessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure();
                ourSessionFactory = configuration.buildSessionFactory();
                return ourSessionFactory;
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        } else {
            return ourSessionFactory;
        }
    }

}
