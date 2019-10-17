package ru.lanit.demodb.repository.interfaces;

import ru.lanit.demodb.entity.People;

import java.util.List;

public interface PeopleRepositoryInterface {

    void savePeople(People people);

    List<People> getPeoples();

    People getById(int peopleId);
}
