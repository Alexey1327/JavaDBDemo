package ru.lanit.demodb.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.demodb.entity.People;
import ru.lanit.demodb.repository.interfaces.PeopleRepositoryInterface;

import java.util.List;

@Component
@Transactional
public class PeopleRepository implements PeopleRepositoryInterface {

    private SessionFactory sessionFactory;

    @Autowired
    public PeopleRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public void savePeople(People people) {
        getSession().save(people);
    }

    public List<People> getPeoples() {
        Query<People> query = getSession().createQuery("select distinct p from People p left join fetch p.addressList", People.class);
        return query.list();
    }

    public People getById(int peopleId) {
        return getSession().get(People.class, peopleId);
    }
}
