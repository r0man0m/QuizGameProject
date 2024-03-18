package models.games;

import models.GameTypes;
import models.content.AnotherContent;
import models.games.abstracts.AbstractGame;

public class AnotherGame extends AbstractGame {
    public AnotherGame(AnotherContent anotherQuestions, GameTypes types) {
        super(anotherQuestions, types);
    }
}
