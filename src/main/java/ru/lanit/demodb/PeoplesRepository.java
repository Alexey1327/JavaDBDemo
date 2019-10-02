package ru.lanit.demodb;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.lanit.demodb.entity.People;

public class PeoplesRepository {

    private final SessionFactory ourSessionFactory;

    public PeoplesRepository() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public void savePeople(People people) {
        try (Session session = getSession()) {
            session.beginTransaction();
            session.save(people);
            session.getTransaction().commit();
        }
    }
}
