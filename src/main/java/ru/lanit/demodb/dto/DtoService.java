package ru.lanit.demodb.dto;

import ru.lanit.demodb.entity.Address;
import ru.lanit.demodb.entity.People;
import ru.lanit.demodb.repository.PeopleRepository;

import java.util.ArrayList;
import java.util.List;

public class DtoService {

    private static DtoService dtoService;

    public static DtoService getInstance() {
        if (dtoService == null) {
            dtoService = new DtoService();
        }
        return dtoService;
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
