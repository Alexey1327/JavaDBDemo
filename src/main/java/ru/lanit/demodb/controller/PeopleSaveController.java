package ru.lanit.demodb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.lanit.demodb.repository.PeopleRepository;
import ru.lanit.demodb.entity.Address;
import ru.lanit.demodb.entity.People;

import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

@Controller
@RequestMapping("/people_save")
public class PeopleSaveController {
    private static final String FIRST_NAME_PARAM  = "first-name";
    private static final String MIDDLE_NAME_PARAM = "middle-name";
    private static final String LAST_NAME_PARAM   = "last-name";
    private static final String BIRTH_DATE_PARAM  = "birth-date";

    private final Logger logger = Logger.getLogger(String.valueOf(PeopleSaveController.class));

    @RequestMapping(method = RequestMethod.POST)
    private void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            List<Address> addressList = new ArrayList<>();
            PeopleRepository.getInstance().savePeople(new People(
                    request.getParameter(FIRST_NAME_PARAM),
                    request.getParameter(MIDDLE_NAME_PARAM),
                    request.getParameter(LAST_NAME_PARAM),
                    request.getParameter(BIRTH_DATE_PARAM),
                    addressList
            ));
            response.getWriter().println("People saved successfully");
        } catch (Exception e){
            throw new ServletException(e.getMessage(), e);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
