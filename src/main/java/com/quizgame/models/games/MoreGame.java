package com.quizgame.models.games;

import com.quizgame.models.GameTypes;
import com.quizgame.models.content.MoreContent;
import com.quizgame.models.games.abstracts.AbstractGame;


public class MoreGame extends AbstractGame {
    public MoreGame(MoreContent moreQuestion, GameTypes types) {
        super(moreQuestion, types);
    }

}
