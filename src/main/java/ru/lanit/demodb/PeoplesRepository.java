package ru.lanit.demodb;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import ru.lanit.demodb.entity.People;

public class PeoplesRepository {

    private Session getSession() throws HibernateException {
        return DBSession.getInstance().openSession();
    }

    public void savePeople(People people) {
        try (Session session = getSession()) {
            session.beginTransaction();
            session.save(people);
            session.getTransaction().commit();
        }
    }
}
