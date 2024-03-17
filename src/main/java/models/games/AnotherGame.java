package models.games;

import models.GameTypes;
import models.content.AnotherContent;
import models.games.abstracts.AbstractGame;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AnotherGame extends AbstractGame {
    public AnotherGame(AnotherContent anotherQuestions, GameTypes types) {

        super(anotherQuestions, types);
    }

    @Override
    public void action(HttpSession session, HttpServletRequest request, HttpServletResponse response,  Integer number) throws ServletException, IOException {
        //request.getRequestDispatcher("notContent.jsp").forward(request, response);
        response.sendRedirect("notContent.jsp");
    }
}
