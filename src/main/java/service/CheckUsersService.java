package service;

import models.User;

import java.util.List;

public class CheckUsersService {
    private List<User>userList;

    public CheckUsersService(List<User> userList) {
        this.userList = userList;
    }
    public boolean check(User user){
        boolean isExists = false;
        for (User U: userList){
            if (U.equals(user)){
                isExists = true;
                break;
            }
        }
        return isExists;
    }
}
