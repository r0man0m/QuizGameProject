import interfaces.Content;
import interfaces.Games;
import lombok.extern.slf4j.Slf4j;
import models.GameTypes;
import models.content.UfoContent;
import models.games.UfoGame;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class UfoGameTest {
    @Mock
    HttpServletRequest mockRequest;
    @Mock
    HttpServletResponse mockResponse;
    @Mock
    HttpSession mockSession;
    @Mock
    RequestDispatcher mockRequestDispatcher;
    private Content gameContent;

    private Games game;

    @BeforeAll
    public void init() {
        gameContent = new UfoContent();
        game = new UfoGame(new UfoContent(), GameTypes.UFO);
    }

    @Test
    public void ufoMainGameTest() throws ServletException, IOException {
        Mockito.when(mockRequest.getParameter("button")).thenReturn("1");
        Mockito.when(mockRequest.getRequestDispatcher("game.jsp")).thenReturn(mockRequestDispatcher);
        for (int i = 0; i < gameContent.getQuestions().size() - 1; i++) {
            game.action(mockSession, mockRequest, mockResponse, i);

            Mockito.verify(mockSession).setAttribute("question", gameContent.getQuestions().get(i));
            log.debug("Question " + gameContent.getQuestions().get(i));
            Mockito.verify(mockSession).setAttribute("answer1", gameContent.getAnswer(i).get(0));
            log.debug("Answer 1 " + gameContent.getAnswer(i).get(0));
            Mockito.verify(mockSession).setAttribute("answer2", gameContent.getAnswer(i).get(1));
            log.debug("Answer 2 " + gameContent.getAnswer(i).get(1));
        }
    }

    @Test
    public void looseUfoGameTest() throws ServletException, IOException {
        Mockito.when(mockRequest.getParameter("button")).thenReturn("2");
        Mockito.when(mockRequest.getRequestDispatcher("loose.jsp")).thenReturn(mockRequestDispatcher);
        for (int i = 1; i <= 3; i++) {
            game.action(mockSession, mockRequest, mockResponse, i);
            Mockito.verify(mockSession).setAttribute("loose", gameContent.getDefeatMessages().get(i - 1));
            log.debug("Loose message " + gameContent.getDefeatMessages().get(i - 1));
        }
    }

    @Test
    public void winUfoGameTest() throws ServletException, IOException {
        Mockito.when(mockRequest.getParameter("button")).thenReturn("1");
        Mockito.when(mockRequest.getRequestDispatcher("win.jsp")).thenReturn(mockRequestDispatcher);
        game.action(mockSession, mockRequest, mockResponse, 3);
        Mockito.verify(mockSession).setAttribute("win", gameContent.getQuestions().get(3));
        log.debug("Win message " + gameContent.getQuestions().get(3));
    }
}
