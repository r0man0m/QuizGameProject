package service;

public class UserCounter {
    private static UserCounter instance = new UserCounter();
    private Integer countUser = 0;

    private UserCounter() {
    }
    public static synchronized UserCounter getInstance(){
        if (instance == null){
            return new UserCounter();
        }
        return instance;
    }

    public Integer getCountUser() {
        return countUser;
    }

    public void setCountUser(Integer countUser) {
        this.countUser = countUser;
    }
}
