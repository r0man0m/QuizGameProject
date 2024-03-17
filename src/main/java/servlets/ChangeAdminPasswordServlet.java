package servlets;

import service.PasswordSaver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/change")
public class ChangeAdminPasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("changePasswordPage.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PasswordSaver saver = PasswordSaver.getInstance();
        saver.setPassword(Integer.valueOf(req.getParameter("change")));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/adminLoginPage.jsp");
        dispatcher.forward(req, resp);
    }
}
