package ru.lanit.demodb.repository;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.demodb.entity.People;
import ru.lanit.demodb.repository.interfaces.PeopleRepositoryInterface;

import java.util.List;

@Component
@Transactional(readOnly = true)
public class PeopleRepository implements PeopleRepositoryInterface {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }


//    private Session getSession() throws HibernateException {
//        return DBSessionFactory.getInstance().openSession();
//    }

    public void savePeople(People people) {
        try (Session session = getSession()) {
            session.beginTransaction();
            session.save(people);
            session.getTransaction().commit();
        }
    }

    public List<People> getPeoples() {
        try (Session session = getSession()) {
            Query query = session.createQuery("select distinct p from People p left join fetch p.addressList");
            return query.list();
        }
    }

    public People getById(int peopleId) {
        try (Session session = getSession()) {
            return session.get(People.class, peopleId);
        }
    }
}
