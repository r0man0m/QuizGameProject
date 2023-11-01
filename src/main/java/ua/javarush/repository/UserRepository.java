package ua.javarush.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.javarush.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);

    private HashMap<Integer, User> db = new HashMap<>();

    public UserRepository() {
        db.put(0, new User());
    }

    public void save(Integer id, User user) {
        LOGGER.info(String.format("Created user with id: %d", id));
        db.put(id, user);
    }

    public void delete(Integer id) {
        db.remove(id);
        LOGGER.info(String.format("Deleted user with id: %d", id));
    }

    public List<User> getAllUser() {
        LOGGER.info(String.format("Get All users from DB!"));
        return new ArrayList<>(db.values());
    }

    public Optional<User> getById(Integer id) {
        return Optional.ofNullable(db.get(id));
    }
}
