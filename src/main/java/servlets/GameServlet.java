package servlets;

import interfaces.Games;
import service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    GameService service = GameService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        Games game = (Games) session.getAttribute("game");
        session.setAttribute("question", game.getContent().getQuestion(0));
        session.setAttribute("answer1", game.getContent().getAnswer(0).get(0));
        session.setAttribute("answer2", game.getContent().getAnswer(0).get(1));
        req.getRequestDispatcher("game.jsp").forward(req,resp);
        service.getIterator().setCount(1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        Games game = (Games) session.getAttribute("game");
        Integer number = service.getIterator().getCount();
            game.action(session, req, resp, number);
            service.getIterator().setCount(number + 1);

    }
}
