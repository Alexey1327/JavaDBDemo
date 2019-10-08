package ru.lanit.demodb.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import ru.lanit.demodb.entity.Address;

public class AddressRepository {

    private Session getSession() throws HibernateException {
        return DBSessionFactory.getInstance().openSession();
    }

    public void saveAddress(Address address) {
        try (Session session = getSession()) {
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
        }
    }
}
