package ru.lanit.demodb.servlets;

import ru.lanit.demodb.JDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Logger;

@WebServlet(name = "FormServlet", urlPatterns = "/form-save")
public class FormServlet extends HttpServlet {

    private static final String FIRST_NAME_PARAM  = "first-name";
    private static final String MIDDLE_NAME_PARAM = "middle-name";
    private static final String LAST_NAME_PARAM   = "last-name";
    private static final String BIRTH_DATE_PARAM  = "birth-date";

    private final Logger logger = Logger.getLogger(String.valueOf(FormServlet.class));

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            JDBC jdbc = new JDBC();
            jdbc.savePeople(
                request.getParameter(FIRST_NAME_PARAM),
                request.getParameter(MIDDLE_NAME_PARAM),
                request.getParameter(LAST_NAME_PARAM),
                request.getParameter(BIRTH_DATE_PARAM));
            response.getWriter().println("People saved successfully");
        } catch (SQLException | ClassNotFoundException e) {
            this.logger.info(Arrays.toString(e.getStackTrace()));
            response.getWriter().println("Something wrong: " + e.getMessage());
        }
    }
}
