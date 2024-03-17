package models.games;

import models.GameTypes;
import models.content.MoreContent;
import models.games.abstracts.AbstractGame;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MoreGame extends AbstractGame {
    public MoreGame(MoreContent moreQuestion, GameTypes types) {
        super(moreQuestion, types);
    }

    @Override
    public void action(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer number) throws ServletException, IOException {
        request.getRequestDispatcher("notContent.jsp").forward(request, response);
    }
}
