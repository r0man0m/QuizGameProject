package interfaces;

import models.GameTypes;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface Games {
    Integer getId();
    User getUser();
    GameTypes getType();
    public void setType(GameTypes type);
    void setId(Integer id);
    void setUser(User user);
    Content getContent();
    void action(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer number) throws ServletException, IOException;
}
