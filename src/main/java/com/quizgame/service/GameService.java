package com.quizgame.service;

import com.quizgame.exceptions.NotUserExistsException;
import com.quizgame.models.GameTypes;
import com.quizgame.models.User;
import com.quizgame.models.games.abstracts.AbstractGame;
import com.quizgame.repositories.DataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameService {
    private DataBase userDataBase = new DataBase();
    private static final GameService instance = new GameService();
    private final UserCounter userCounter = UserCounter.getInstance();
    private final GameCounter gameCounter = new GameCounter();
    private final GameConstructor constructor = new GameConstructor();
    private final GameIterationSaver iterator = new GameIterationSaver();
    private final Map<Integer, AbstractGame> db = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(GameService.class);

    private GameService() {
    }

    public static synchronized GameService getInstance() {
        if (instance == null) {
            return new GameService();
        }
        return instance;
    }

    public void setGame(AbstractGame game, Integer id) {
        db.put(id, game);
        logger.info("Game " + game.getType() + " Game id " + game.getId() + " set ");
    }

    public AbstractGame getGame(Integer id) {
        logger.info("Get game id " + id + db.get(id));
        return db.get(id);
    }

    public void setUser(User user, Integer id) {
        userDataBase.setUser(user, id);
        logger.info("User name " + user.getName() + " user nickname " + user.getNickName() + " user id " + id + " set ");
    }

    public void setUserCounter(Integer counter) {
        userCounter.setCountUser(counter);
        logger.info("Set user counter " + counter);
    }

    public Integer getUserCounter() {
        logger.info("Get user counter " + userCounter.getCountUser());
        return userCounter.getCountUser();
    }

    public void setGameCounter(Integer counter) {
        gameCounter.setCount(counter);
        logger.info("Set game counter " + counter);
    }

    public Integer getGameCounter() {
        logger.info("Get game counter " + gameCounter.getCount());
        return gameCounter.getCount();
    }

    public List<User> getAllUsers() {
        logger.info("Get all users ");
        return userDataBase.getAll();
    }

    public DataBase getUserDataBase() {
        logger.info("Get User data base");
        return userDataBase;
    }

    public boolean checkUser(User user) {
        CheckUsersService checkUsersService = new CheckUsersService(getAllUsers());
        logger.info("User is exists " + checkUsersService.check(user));
        return checkUsersService.check(user);
    }

    public void delAllUsers() {
        userDataBase.delAllUsers();
        logger.info("All users deleted");
        userCounter.setCountUser(0);
        logger.info("Total users " + userCounter.getCountUser());
    }

    public void removeUser(String name, String nickName, int id) {
        User user = null;
        for (Map.Entry<Integer, User> e : getUserDataBase().getUserMap().entrySet()) {
            if (e.getValue().getName().equals(name) && e.getValue().getNickName().equals(nickName)
                    && e.getValue().getId().equals(id)) {
                user = getUserDataBase().getUserMap().get(id);
                if (getUserCounter() != 0) {
                    setUserCounter(getUserCounter() - 1);
                }
                break;
            }
        }
        if (checkUser(user)) {
            getUserDataBase().getUserMap().remove(user.getId());
            logger.info("User " + user.getId() + " deleted ");
        } else {
            logger.error("User is not exists!");
            throw new NotUserExistsException("User is not exists!");
        }
    }

    public AbstractGame createGame(GameTypes type, User user) {
        AbstractGame game = constructor.getGame(type);
        game.setId(getGameCounter());
        game.setUser(user);
        logger.info("Game " + game.getType() + " game id " + game.getId() + " created");
        return game;
    }

    public GameIterationSaver getIterator() {
        logger.info("Game iterator " + iterator.getCount());
        return iterator;
    }
}
