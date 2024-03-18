package com.quizgame.service;

import com.quizgame.models.User;

import java.util.List;

public class CheckUsersService {
    private final List<User> userList;

    public CheckUsersService(List<User> userList) {
        this.userList = userList;
    }

    public boolean check(User user) {
        return userList.stream().anyMatch(s -> s.equals(user));
    }
}
