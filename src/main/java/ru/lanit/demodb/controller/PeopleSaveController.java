package ru.lanit.demodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.lanit.demodb.repository.PeopleRepository;
import ru.lanit.demodb.entity.Address;
import ru.lanit.demodb.entity.People;

import org.springframework.stereotype.Controller;
import ru.lanit.demodb.repository.interfaces.PeopleRepositoryInterface;

import javax.servlet.ServletException;
import java.util.*;
import java.util.logging.Logger;

@Controller
@RequestMapping("/people_save")
@Transactional
public class PeopleSaveController {

    private static final String FIRST_NAME_PARAM  = "first-name";
    private static final String MIDDLE_NAME_PARAM = "middle-name";
    private static final String LAST_NAME_PARAM   = "last-name";
    private static final String BIRTH_DATE_PARAM  = "birth-date";

    private static final String SUCCESS_RESULT_MSG  = "People saved successfully";

    private final Logger logger = Logger.getLogger(String.valueOf(PeopleSaveController.class));

    private PeopleRepositoryInterface peopleRepository;

    @Autowired
    public PeopleSaveController(PeopleRepositoryInterface peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    private String peopleSaveAction(
            @RequestParam(name = FIRST_NAME_PARAM) String firstName,
            @RequestParam(name = MIDDLE_NAME_PARAM) String middleName,
            @RequestParam(name = LAST_NAME_PARAM) String lastName,
            @RequestParam(name = BIRTH_DATE_PARAM) String birthDate) throws ServletException {
        try{
            List<Address> addressList = new ArrayList<>();
            peopleRepository.savePeople(new People(
                    firstName,
                    middleName,
                    lastName,
                    birthDate,
                    addressList
            ));

            return SUCCESS_RESULT_MSG;
        } catch (Exception e){
            logger.info(e.getMessage());
            throw new ServletException(e.getMessage(), e);
        }
    }
}
