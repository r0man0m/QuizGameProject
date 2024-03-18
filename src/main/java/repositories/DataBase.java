package repositories;

import interfaces.UserDataBase;
import models.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataBase implements UserDataBase {
    private static DataBase instance = new DataBase();
    private Map<Integer, User> userMap = new HashMap<>();

    private DataBase() {
    }
    public static synchronized DataBase getInstance(){
        if(instance == null){
            return new DataBase();
        }
        return instance;
    }
    public void setUser(User user, Integer id){
        userMap.put(id, user);
    }

    public User getUser(Integer id){
        return userMap.get(id);
    }

    public List <User> getAll(){
        return new ArrayList<>(userMap.values());
    }

    public Map <Integer, User> getUserMap() {
        return userMap;
    }

    public void delAllUsers(){
        userMap.clear();
    }
}
