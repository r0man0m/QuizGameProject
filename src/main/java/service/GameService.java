package service;

import exceptions.NotUserExistsException;
import interfaces.Games;
import models.GameTypes;
import models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repositories.UserDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameService {
    private static GameService instance = new GameService();
    private UserDataBase userDataBase = UserDataBase.getInstance();
    private UserCounter userCounter = UserCounter.getInstance();
    private GameCounter gameCounter = GameCounter.getInstance();
    private CheckUsersService checkUsersService;
    private GameConstructor constructor = new GameConstructor();
    private GameIterator iterator = new GameIterator();

    private Map<Integer, Games>db = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(GameService.class);

    private GameService() {
    }

    public static synchronized GameService getInstance(){
        if (instance == null){
            return new GameService();
        }
        return instance;
    }
    public void setGame(Games game, Integer id){
        db.put(id, game);
        logger.info("Game " + game.getType() + " Game id " + game.getId() + " set ");
    }
    public Games getGame(Integer id){
        logger.info("Get game id " + id + db.get(id));
        return db.get(id);
    }
    public void setUser(User user, Integer id){
        userDataBase.setUser(user, id);
        logger.info("User name " + user.getName() + " user nickname " + user.getNickName() + " user id " + id + " set ");
    }
    public void setUserCounter(Integer counter){
        userCounter.setCountUser(counter);
        logger.info("Set user counter " + counter);
    }
    public Integer getUserCounter(){
        logger.info("Get user counter " + userCounter.getCountUser());
        return userCounter.getCountUser();
    }
    public void setGameCounter(Integer counter){
        gameCounter.setCount(counter);
        logger.info("Set game counter " + counter);
    }
    public Integer getGameCounter(){
        logger.info("Get game counter " + gameCounter.getCount());
        return gameCounter.getCount();
    }
    public List<User> getAllUsers(){
        logger.info("Get all users ");
        return userDataBase.getAll();
    }
    public UserDataBase getUserDataBase(){
        logger.info("Get User data base");
        return userDataBase;
    }

    public boolean checkUser(User user){
        checkUsersService = new CheckUsersService(getAllUsers());
        logger.info("User is exists " + checkUsersService.check(user));
        return checkUsersService.check(user);
    }
    public void delAllUsers(){
        userDataBase.delAllUsers();
        logger.info("All users deleted");
        userCounter.setCountUser(0);
        logger.info("Total users " + userCounter.getCountUser());
    }
    public void removeUser(String name, String nickName, Integer id) {
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
        if(checkUser(user)) {
            getUserDataBase().getUserMap().remove(user.getId());
            logger.info("User " + user.getId() + " deleted ");
        }else {
            logger.error("User is not exists!");
            throw new NotUserExistsException("User is not exists!");
        }
    }
    public Games createGame(GameTypes type, User user){
        Games game = constructor.getGame(type);
        game.setId(getGameCounter());
        game.setUser(user);
        logger.info("Game " + game.getType() + " game id " + game.getId() + " created");
        return game;
    }

    public GameIterator getIterator() {
        logger.info("Game iterator " + iterator.getCount());
        return iterator;
    }
}
