package models.games;

import models.GameTypes;
import models.content.MoreContent;
import models.games.abstracts.AbstractGame;


public class MoreGame extends AbstractGame {
    public MoreGame(MoreContent moreQuestion, GameTypes types) {
        super(moreQuestion, types);
    }

}
