package ru.lanit.demodb.services;

import ru.lanit.demodb.dto.AddressDto;
import ru.lanit.demodb.dto.PeopleDto;
import ru.lanit.demodb.entity.Address;
import ru.lanit.demodb.entity.People;
import ru.lanit.demodb.repository.PeopleRepository;

import java.util.ArrayList;
import java.util.List;

public class PeopleService {

    private static PeopleService peopleService;

    public static PeopleService getInstance() {
        if (peopleService == null) {
            peopleService = new PeopleService();
        }
        return peopleService;
    }

    public List<PeopleDto> getPeoplesData() {
        
        List<People> peoples = PeopleRepository.getInstance().getPeoples();
        List<PeopleDto> list = new ArrayList<>();

        for (People people : peoples) {
            PeopleDto peopleDto = new PeopleDto(people.getId(), people.getFio(), people.getBirthDate());
            List<AddressDto> addressesList = new ArrayList<>();
            for (Address address : people.getAddressList()) {
                addressesList.add(new AddressDto(address.getId(), address.getCity(), address.getStreet(), address.getHouse(), address.getFlat()));
            }

            peopleDto.setAddressList(addressesList);
            list.add(peopleDto);
        }
        return list;
    }
}
