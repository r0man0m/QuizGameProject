package servlets;

import interfaces.Games;
import models.GameTypes;
import models.User;
import service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/setGame")
public class SetGameServlet extends HttpServlet {
    private GameService service = GameService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("choiceGame.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Games game = null;
        HttpSession session = req.getSession(true);
        User user = (User) session.getAttribute("user");
        switch (req.getParameter("name")){
            case "ufo":{
                service.setGame(service.createGame(GameTypes.UFO, user), service.getGameCounter());
                createNewGame(game, session);
                user.setGameCount(user.getGameCount() + 1);
                resp.sendRedirect("game");
                break;
            }
            case "another":{
                service.setGame(service.createGame(GameTypes.ANOTHER, user), service.getGameCounter());
                createNewGame(game, session);
                user.setGameCount(user.getGameCount() + 1);
                resp.sendRedirect("game");
                break;
            }
            case "more":{
                service.setGame(service.createGame(GameTypes.MORE, user), service.getGameCounter());
                createNewGame(game, session);
                user.setGameCount(user.getGameCount() + 1);
                resp.sendRedirect("game");
                break;

            }
        }
//        user.setGameCount(user.getGameCount() + 1);
//        resp.sendRedirect("game");
    }
    public void createNewGame(Games game, HttpSession session){
        game = service.getGame(service.getGameCounter());
        service.setGameCounter(service.getGameCounter() + 1);
        session.setAttribute("game", game);
    }
}
