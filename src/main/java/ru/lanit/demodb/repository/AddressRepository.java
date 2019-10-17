package ru.lanit.demodb.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.demodb.entity.Address;
import ru.lanit.demodb.repository.interfaces.AddressRepositoryInterface;

@Component
@Transactional(readOnly = true)
public class AddressRepository implements AddressRepositoryInterface {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
//    private DBSessionFactory dbSessionFactory;

//    private Session getSession() throws HibernateException {
//        return DBSessionFactory.getInstance().openSession();
//    }

    public void saveAddress(Address address) {
        try (Session session = getSession()) {
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
        }
    }
}
