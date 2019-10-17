package ru.lanit.demodb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lanit.demodb.dto.AddressDto;
import ru.lanit.demodb.dto.PeopleDto;
import ru.lanit.demodb.entity.Address;
import ru.lanit.demodb.entity.People;
import ru.lanit.demodb.repository.interfaces.PeopleRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService {

    private PeopleRepositoryInterface peopleRepository;

    @Autowired
    public PeopleService(PeopleRepositoryInterface peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<PeopleDto> getPeoplesData() {
        
        List<People> peoples = peopleRepository.getPeoples();
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
