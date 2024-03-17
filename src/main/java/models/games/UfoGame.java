package models.games;

import models.GameTypes;
import models.content.UfoContent;
import models.games.abstracts.AbstractGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UfoGame extends AbstractGame {
    private static final Logger logger = LoggerFactory.getLogger(UfoGame.class);

    public UfoGame(UfoContent ufoQuestions, GameTypes types) {
        super(ufoQuestions, types);
    }

    public void action(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer number) throws ServletException, IOException {
        if (request.getParameter("button").equals("1")) {
            session.setAttribute("question", getContent().getQuestion(number));
            if (number == getContent().getQuestions().size() - 1) {
                session.setAttribute("win", getContent().getQuestions().get(number));
                request.getRequestDispatcher("win.jsp").forward(request, response);
            } else {
                session.setAttribute("answer1", getContent().getAnswer(number).get(0));
                session.setAttribute("answer2", getContent().getAnswer(number).get(1));
                request.getRequestDispatcher("game.jsp").forward(request, response);
            }
        } else if (request.getParameter("button").equals("2")) {
            session.setAttribute("loose", getContent().getDefeatMessages().get(number - 1));
            request.getRequestDispatcher("loose.jsp").forward(request, response);
        }

    }
}

