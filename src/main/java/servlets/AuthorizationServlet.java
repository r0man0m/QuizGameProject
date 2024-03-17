package servlets;

import exceptions.NotUserExistsException;
import models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/auth")
public class AuthorizationServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizationServlet.class);
    GameService service = GameService.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String nick = req.getParameter("nickName");
        User user = null;
        for (User U: service.getAllUsers()){
            if(U.getNickName().equals(nick)){
                user = U;
                break;
            }
        }
        session.setAttribute("user", user);
        if(!service.checkUser(user)){
            logger.error("User is not exists!");
            throw new NotUserExistsException("User is not exists");
        }else {
            req.getRequestDispatcher("choiceGame.jsp").forward(req, resp);
        }
    }
}
