package ru.lanit.demodb.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.demodb.entity.Address;
import ru.lanit.demodb.repository.interfaces.AddressRepositoryInterface;

@Component
@Transactional
public class AddressRepository implements AddressRepositoryInterface {

    private SessionFactory sessionFactory;

    @Autowired
    public AddressRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public void saveAddress(Address address) {
            getSession().save(address);
    }
}
