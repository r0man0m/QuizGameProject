package ua.javarush.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.javarush.models.User;
import ua.javarush.repository.UserRepository;
import ua.javarush.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServlet.class);
    private static Integer USER_ID_COUNTER = 1;

    private UserService userService = new UserService(new UserRepository());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User(req.getParameter("name"),
                Integer.valueOf(req.getParameter("age")),
                req.getParameter("email"));

        userService.create(USER_ID_COUNTER++, user);
        resp.setStatus(201);
        req.setAttribute("users", userService.getAllUsers());
        req.getRequestDispatcher("usersPage.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userService.getAllUsers());
        req.getRequestDispatcher("usersPage.jsp").forward(req, resp);
    }
}
