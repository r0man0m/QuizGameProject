package models;

public enum GameTypes {
    UFO("Ufo"),
    ANOTHER("Another"),
    MORE("More");
    private String title;

    GameTypes(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "GameTypes{" +
                "title='" + title + '\'' +
                '}';
    }
}
