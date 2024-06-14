package com.quizgame.service;

import com.quizgame.models.GameTypes;
import com.quizgame.models.content.AnotherContent;
import com.quizgame.models.content.MoreContent;
import com.quizgame.models.content.UfoContent;
import com.quizgame.models.games.AnotherGame;
import com.quizgame.models.games.MoreGame;
import com.quizgame.models.games.UfoGame;
import com.quizgame.models.games.abstracts.AbstractGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameConstructor {
    private static final Logger logger = LoggerFactory.getLogger(GameConstructor.class);

    public AbstractGame getGame(GameTypes type) {
        AbstractGame game = null;
        switch (type) {
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
