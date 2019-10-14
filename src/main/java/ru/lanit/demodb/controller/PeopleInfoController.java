package ru.lanit.demodb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.lanit.demodb.services.PeopleService;
import ru.lanit.demodb.dto.PeopleDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/people_info")
public class PeopleInfoController {

    private final static String JSP_PAGE = "people_info.jsp";

    @RequestMapping(method = RequestMethod.GET)
    private void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<PeopleDto> peopleListDto = PeopleService.getInstance().getPeoplesData();
        req.setAttribute("peopleListDto", peopleListDto);

        req.getRequestDispatcher(JSP_PAGE).forward(req,resp);
    }

    @RequestMapping(method = RequestMethod.POST)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
