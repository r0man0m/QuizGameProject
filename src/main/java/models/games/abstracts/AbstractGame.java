package models.games.abstracts;

import interfaces.Content;
import interfaces.Games;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import models.GameTypes;
import models.User;

import java.util.Objects;
@Data
public abstract class AbstractGame implements Games {
    @Setter
    private Integer id;
    private User user;
    private GameTypes type;
    @Getter
    private Content content;

    public AbstractGame(Content content, GameTypes type) {
        this.content = content;
        this.type = type;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractGame game = (AbstractGame) o;
        return Objects.equals(id, game.id) && Objects.equals(user, game.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, type, content);
    }

    @Override
    public String toString() {
        return type.getTitle() + " id= " + getId() + " user= " + getUser();
    }

}
