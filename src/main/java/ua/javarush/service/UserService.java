package ua.javarush.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.javarush.exceptions.InvalidParamException;
import ua.javarush.exceptions.UserNotFoundException;
import ua.javarush.models.User;
import ua.javarush.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class UserService {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(Integer id, User user) {
        LOGGER.info("User received: " + user);
        if (id <= 0) {
            LOGGER.warn(String.format("ID less or equal 0"));
            throw new InvalidParamException("Id cannot be less or equal zero!");
        }
        validation(user);
        userRepository.save(id, user);
    }

    public void delete(Integer id) {
        userRepository.getById(id).orElseThrow(() -> new UserNotFoundException(
                String.format("User with id = %d not found!", id)
        ));
        userRepository.delete(id);
    }

    public List<User> getAllUsers() {
        LOGGER.info(String.format("Get all users!"));
        return userRepository.getAllUser();
    }

    private void validation(User user) {
        if (Objects.isNull(user)) {
            LOGGER.warn("User is null");
            throw new InvalidParamException("User is null");
        }
        if (user.getName().isEmpty()) {
            LOGGER.warn("User firstName is empty");
            throw new InvalidParamException("User firstName is empty");
        }
        if (user.getAge() <= 0) {
            LOGGER.warn("User age is 0 or less than zero!");
            throw new InvalidParamException("User age is 0 or less than zero!");
        }
        if (user.getEmail().isEmpty()) {
            LOGGER.warn("User email is empty");
            throw new InvalidParamException("User email is empty");
        }
        if (!VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail()).matches()) {
            LOGGER.warn("User email is invalid");
            throw new InvalidParamException("User email is invalid");
        }
    }

}
