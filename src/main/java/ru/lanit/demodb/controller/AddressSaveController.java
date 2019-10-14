package ru.lanit.demodb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.lanit.demodb.entity.Address;
import ru.lanit.demodb.entity.People;
import ru.lanit.demodb.repository.AddressRepository;
import ru.lanit.demodb.repository.PeopleRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/address_save")
public class AddressSaveController {

    private final static String JSP_PAGE = "address_save.jsp";

    private static final String PEOPLE_ID_PARAM = "people_id";
    private static final String CITY_PARAM = "city";
    private static final String FLAT_PARAM = "flat";
    private static final String HOUSE_PARAM = "house";
    private static final String STREET_PARAM = "street";

    @RequestMapping(method = RequestMethod.GET)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List peopleList = PeopleRepository.getInstance().getPeoples();
        req.setAttribute("peopleList", peopleList);

        req.getRequestDispatcher(JSP_PAGE).forward(req,resp);
    }

    @RequestMapping(method = RequestMethod.POST)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int peopleId = Integer.parseInt(req.getParameter(PEOPLE_ID_PARAM));

        if (peopleId == 0) {
            throw new ServletException("People_id is null");
        }

        People people = PeopleRepository.getInstance().getById(peopleId);

        if (people == null) {
            throw new ServletException(String.format("People with id %s not found", peopleId));
        }

        Address address = new Address(
                req.getParameter(CITY_PARAM),
                req.getParameter(STREET_PARAM),
                req.getParameter(HOUSE_PARAM)
        );

        if (!req.getParameter(FLAT_PARAM).equals("")) {
            address.setFlat(Integer.parseInt(req.getParameter(FLAT_PARAM)));
        }

        address.setPeople(people);
        AddressRepository.getInstance().saveAddress(address);

        resp.getWriter().println("Address saved successfully");
    }
}