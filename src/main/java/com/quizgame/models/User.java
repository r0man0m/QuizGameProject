package com.quizgame.models;

import lombok.*;

@Data
@EqualsAndHashCode
@ToString
public class User {
    private final String name;
    private final String nickName;
    private Integer id;
    @Setter
    @Getter
    private int gameCount = 0;

    public User(String name, String nickName, Integer id) {
        this.name = name;
        this.nickName = nickName;
        this.id = id;
    }

    public User(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
    }
}

