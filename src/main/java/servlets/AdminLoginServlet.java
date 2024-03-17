package servlets;

import exceptions.WrongPasswordException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.PasswordSaver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/passw")
public class AdminLoginServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(AdminLoginServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      PasswordSaver passwordSaver = PasswordSaver.getInstance();
        RequestDispatcher dispatcher = req.getRequestDispatcher("adminPage.jsp");
      Integer pass = Integer.valueOf(req.getParameter("pass"));
      if(pass == passwordSaver.getPassword()){
          dispatcher.forward(req,resp);
      }else {
          logger.error("Wrong password in AdminLoginServlet!");
          throw new WrongPasswordException("Wrong password!");
      }
    }
}
