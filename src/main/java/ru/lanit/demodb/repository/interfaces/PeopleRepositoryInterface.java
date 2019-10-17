package ru.lanit.demodb.repository.interfaces;

import ru.lanit.demodb.entity.People;

import java.util.List;

public interface PeopleRepositoryInterface {

    public void savePeople(People people);

    public List<People> getPeoples();

    public People getById(int peopleId);
}
