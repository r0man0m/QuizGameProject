package servlets;

import service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/del")
public class DeleteUserServlet extends HttpServlet {
    private GameService service = GameService.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("button").equals("one")){
            String userName = req.getParameter("name");
            String userNick = req.getParameter("nickName");
            Integer idUser = Integer.valueOf(req.getParameter("id"));
            delUser(userName , userNick, idUser);
            resp.sendRedirect("adminPage.jsp");
        }else if (req.getParameter("button").equals("all")){
            delUsers();
            resp.sendRedirect("adminPage.jsp");
        }

    }
    public void delUsers(){
        service.delAllUsers();
    }
    public void delUser(String name, String nickName, Integer id){
        service.removeUser(name, nickName, id);
    }
}
