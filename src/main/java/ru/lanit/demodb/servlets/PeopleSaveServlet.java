package ru.lanit.demodb.servlets;

import ru.lanit.demodb.repository.PeopleRepository;
import ru.lanit.demodb.entity.Address;
import ru.lanit.demodb.entity.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

@WebServlet(name = "PeopleSaveServlet", urlPatterns = "/people_save")
public class PeopleSaveServlet extends HttpServlet {

    private static final String FIRST_NAME_PARAM  = "first-name";
    private static final String MIDDLE_NAME_PARAM = "middle-name";
    private static final String LAST_NAME_PARAM   = "last-name";
    private static final String BIRTH_DATE_PARAM  = "birth-date";

    private final Logger logger = Logger.getLogger(String.valueOf(PeopleSaveServlet.class));

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            PeopleRepository peoplesRepository = new PeopleRepository();
            List<Address> addressList = new ArrayList<>();
            peoplesRepository.savePeople(new People(
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
