package models.games.abstracts;

import interfaces.Content;
import interfaces.Games;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import models.GameTypes;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Data
@ToString
@EqualsAndHashCode
public abstract class AbstractGame implements Games {
    private Integer id;
    private User user;
    private GameTypes type;
    private Content content;

    public AbstractGame(Content content, GameTypes type) {
        this.content = content;
        this.type = type;
    }

    @Override
    public void action(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer number) throws ServletException, IOException {
        request.getRequestDispatcher("notContent.jsp").forward(request, response);
    }
}


