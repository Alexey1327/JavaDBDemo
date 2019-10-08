package ru.lanit.demodb.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import ru.lanit.demodb.entity.Address;

public class AddressRepository {

    private static AddressRepository repoInstance;

    public static AddressRepository getInstance() {
        if (repoInstance == null) {
            repoInstance = new AddressRepository();
        }
        return repoInstance;
    }

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
