package repositories;

import models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDataBase {
    private static UserDataBase instance = new UserDataBase();
    private Map<Integer, User> userMap = new HashMap<>();

    private UserDataBase() {
    }
    public static synchronized UserDataBase getInstance(){
        if(instance == null){
            return new UserDataBase();
        }
        return instance;
    }
    public void setUser(User user, Integer id){
        userMap.put(id, user);
    }
    public User getUser(Integer id){
        return userMap.get(id);
    }
    public List<User>getAll(){
        return new ArrayList<>(userMap.values());
    }
    public Map<Integer, User> getUserMap() {
        return userMap;
    }
    public void delAllUsers(){
        userMap.clear();
    }
}
