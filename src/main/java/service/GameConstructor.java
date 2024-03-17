package service;

import models.GameTypes;
import models.content.AnotherContent;
import models.content.MoreContent;
import models.content.UfoContent;
import models.games.AnotherGame;
import models.games.MoreGame;
import models.games.UfoGame;
import models.games.abstracts.AbstractGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameConstructor {
    private static final Logger logger = LoggerFactory.getLogger(GameConstructor.class);

    public AbstractGame getGame(GameTypes type){
        AbstractGame game = null;
        switch (type){
            case UFO:
                game = new UfoGame(new UfoContent(), GameTypes.UFO);
            break;
            case ANOTHER:
                game = new AnotherGame(new AnotherContent(), GameTypes.ANOTHER);
            break;
            case MORE:
                game = new MoreGame(new MoreContent(), GameTypes.MORE);
        }
        logger.info("Return game type of " + type);
        return game;
    }
}
