package ru.lanit.demodb.repository;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import ru.lanit.demodb.entity.People;

import java.util.List;

public class PeopleRepository {

    private static PeopleRepository repoInstance;

    public static PeopleRepository getInstance() {
        if (repoInstance == null) {
            repoInstance = new PeopleRepository();
        }
        return repoInstance;
    }

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

    public List<People> getPeoples() {
        try (Session session = getSession()) {
            Query query = session.createQuery("select distinct p from People p join fetch p.addressList");
            return query.list();
        }
    }

    public People getById(int peopleId) {
        try (Session session = getSession()) {
            return session.get(People.class, peopleId);
        }
    }
}
