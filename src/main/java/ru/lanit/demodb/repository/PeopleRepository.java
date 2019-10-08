package ru.lanit.demodb.repository;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import ru.lanit.demodb.entity.People;

import java.util.List;

public class PeopleRepository {

    private Session getSession() throws HibernateException {
        return DBSessionFactory.getInstance().openSession();
    }

    public void savePeople(People people) {
        try (Session session = getSession()) {
            session.beginTransaction();
            session.save(people);
            session.getTransaction().commit();
        }
    }

    public void updatePeople(People people) {
        try (Session session = getSession()) {
            session.beginTransaction();
            session.update(people);
            session.getTransaction().commit();
        }
    }

    public List getPeoples() {
        try (Session session = getSession()) {
            Query query = session.createQuery("from People");
            return query.list();
        }
    }

    public People getById(int peopleId) {
        try (Session session = getSession()) {
            return session.get(People.class, peopleId);
        }
    }
}
