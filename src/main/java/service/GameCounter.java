package service;

public class GameCounter {
    private Integer count = 1;
    private static GameCounter instance = new GameCounter();

    private GameCounter() {
    }
    public static synchronized GameCounter getInstance(){
        if (instance == null){
            return new GameCounter();
        }
        return instance;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
