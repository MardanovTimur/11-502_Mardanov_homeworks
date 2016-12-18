import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.itis.inform.dao.JDBConnection;
import ru.itis.inform.dao.UserDao;
import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.messages.Message;
import ru.itis.inform.models.User;

import javax.jws.soap.SOAPBinding;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Тимур on 06.11.2016.
 */
//Всеразличные тесты.
public class GeneralTest {

    private ServiceFactory serviceFactory;
    private UserDao userDao;
    private User user;
    private List<User> users;

    @Before
    public void setup() {
        userDao = mock(UserDao.class);
        user = new User("10001","Name","Login","password",false);
        users = new LinkedList<User>();
    }

    @Test
    public void registrationWillReturnTrue() throws SQLException, Exception {
        users.add(user);
        when(userDao.findUsers("Login")).thenReturn(users);
        assertEquals(userDao.findUsers("Login"),users);
    }

    @Test
    public void serviceTest() throws Exception {

    }
}
