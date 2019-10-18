package ru.lanit.demodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.lanit.demodb.entity.Address;
import ru.lanit.demodb.entity.People;
import ru.lanit.demodb.repository.interfaces.AddressRepositoryInterface;
import ru.lanit.demodb.repository.interfaces.PeopleRepositoryInterface;

import javax.servlet.ServletException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/address_save")
@Transactional
public class AddressSaveController {

    private final static String JSP_PAGE = "address_save";

    private static final String PEOPLE_ID_PARAM_NAME = "people_id";
    private static final String CITY_PARAM_NAME = "city";
    private static final String FLAT_PARAM_NAME = "flat";
    private static final String HOUSE_PARAM_NAME = "house";
    private static final String STREET_PARAM_NAME = "street";

    private static final String SUCCESS_RESULT_MSG  = "Address saved successfully";
    private static final String ERROR_PEOPLE_ID_MSG  = "People_id is null";
    private static final String ERROR_PEOPLE_NOT_FOUND_MSG  = "People with id %s not found";

    private PeopleRepositoryInterface peopleRepository;
    private AddressRepositoryInterface addressRepository;

    @Autowired
    public AddressSaveController(
            PeopleRepositoryInterface peopleRepository,
            AddressRepositoryInterface addressRepository
    ) {
        this.peopleRepository = peopleRepository;
        this.addressRepository = addressRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    protected ModelAndView addressFormAction() {
        Map<String, List<People>> map = new HashMap<>();
        List<People> peopleList = peopleRepository.getPeoplesLazy();
        map.put("peopleList", peopleList);
        return new ModelAndView(JSP_PAGE, map);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String addressSaveAction(
            @RequestParam(name = PEOPLE_ID_PARAM_NAME) Integer peopleId,
            @RequestParam(name = CITY_PARAM_NAME) String cityName,
            @RequestParam(name = FLAT_PARAM_NAME) String flatNumber,
            @RequestParam(name = HOUSE_PARAM_NAME) String houseNumber,
            @RequestParam(name = STREET_PARAM_NAME) String streetName
    ) throws ServletException {

        if (peopleId == 0) {
            throw new ServletException(ERROR_PEOPLE_ID_MSG);
        }

        People people = peopleRepository.getById(peopleId);

        if (people == null) {
            throw new ServletException(String.format(ERROR_PEOPLE_NOT_FOUND_MSG, peopleId));
        }

        Address address = new Address(cityName, streetName, houseNumber);

        if (!flatNumber.equals("")) {
            address.setFlat(Integer.parseInt(flatNumber));
        }

        address.setPeople(people);
        addressRepository.saveAddress(address);

        return SUCCESS_RESULT_MSG;
    }
}