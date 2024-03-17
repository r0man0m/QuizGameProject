
import interfaces.Games;
import lombok.extern.slf4j.Slf4j;
import models.GameTypes;
import models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositories.UserDataBase;
import service.GameConstructor;
import service.GameService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class GameServiceTest {
    private static final User user = new User("TestName", "test", 0);
    private static final List<User>userList = new ArrayList<>();
    private static final GameConstructor gameConstructor = new GameConstructor();

    @Mock
    UserDataBase mockUserDataBase;

    @InjectMocks
    private static GameService service;

    @Test
    public void checkExistsUserTest(){
        userList.add(user);
        Mockito.when(mockUserDataBase.getAll()).thenReturn(userList);
        assertTrue(service.checkUser(user));
    }

    @Test
    public void checkNotExistsUserTest(){
        Mockito.when(mockUserDataBase.getAll()).thenReturn(new ArrayList<>());
        assertFalse(service.checkUser(user));
    }
    @Test
    public void dellAllUsersTest(){
        Mockito.when(mockUserDataBase.getAll()).thenReturn(new ArrayList<>());
        assertEquals(0, service.getAllUsers().size());
    }
    @Test
    public void removeUserTest(){
        service = GameService.getInstance();
        service.setUser(user,user.getId());
        service.removeUser(user.getName(),user.getNickName(), user.getId());
        assertNull(service.getUserDataBase().getUser(user.getId()));
    }
    @ParameterizedTest
    @MethodSource("streamGameTypesFactory")
    public void createGameTest(GameTypes type){
        Games game = gameConstructor.getGame(type);
        game.setUser(user);
        assertEquals(game.getType(), service.createGame(type,user).getType());
        assertEquals(game.getUser(), service.createGame(type,user).getUser());
        log.debug("User name " + service.createGame(type,user).getUser().getName() + " user nickname " + service.createGame(type,user).getUser().getNickName() + " id " + service.createGame(type,user).getUser().getId());
    }
    public static Stream<GameTypes> streamGameTypesFactory(){
        return Stream.of(GameTypes.UFO, GameTypes.ANOTHER, GameTypes.MORE);
    }


}
