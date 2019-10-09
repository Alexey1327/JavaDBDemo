package ru.lanit.demodb.servlets;

import ru.lanit.demodb.dto.DtoService;
import ru.lanit.demodb.dto.PeopleDto;
import ru.lanit.demodb.repository.PeopleRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PeopleInfoServlet", urlPatterns = "/people_info")
public class PeopleInfoServlet extends HttpServlet {

    private final static String JSP_PAGE = "people_info.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<PeopleDto> peopleListDto = DtoService.getInstance().getPeoplesData();
        req.setAttribute("peopleListDto", peopleListDto);

        req.getRequestDispatcher(JSP_PAGE).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
