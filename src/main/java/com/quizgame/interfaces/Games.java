package com.quizgame.interfaces;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface Games {
    void action(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer number) throws ServletException, IOException;
}
