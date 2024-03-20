package com.quizgame.service;

public class UserCounter {
    private static UserCounter instance;
    private Integer countUser = 0;

    private UserCounter() {
    }

    public static synchronized UserCounter getInstance() {
        if (instance == null) {
            instance =  new UserCounter();
        }
        return instance;
    }

    public Integer getCountUser() {
        return countUser;
    }

    public void setCountUser(Integer countUser) {
        this.countUser = countUser;
    }
}
