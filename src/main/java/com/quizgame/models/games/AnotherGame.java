package com.quizgame.models.games;

import com.quizgame.models.GameTypes;
import com.quizgame.models.content.AnotherContent;
import com.quizgame.models.games.abstracts.AbstractGame;

public class AnotherGame extends AbstractGame {
    public AnotherGame(AnotherContent anotherQuestions, GameTypes types) {
        super(anotherQuestions, types);
    }
}
