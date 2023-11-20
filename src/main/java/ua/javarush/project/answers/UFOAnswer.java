package ua.javarush.project.answers;

public class UFOAnswer {

    private String message;
    private String page;

    public UFOAnswer(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
