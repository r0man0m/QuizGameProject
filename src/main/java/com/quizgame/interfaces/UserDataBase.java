package com.quizgame.interfaces;

import com.quizgame.models.User;

import java.util.List;
import java.util.Map;

public interface UserDataBase {
    void setUser(User user, Integer id);

    User getUser(Integer id);

    List<User> getAll();

    Map<Integer, User> getUserMap();

    void delAllUsers();
}
