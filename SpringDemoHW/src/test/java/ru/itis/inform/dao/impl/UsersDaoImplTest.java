package ru.itis.inform.dao.impl;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.itis.inform.TestConfig;
import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.model.Book;
import ru.itis.inform.model.User;

import java.util.LinkedList;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class UsersDaoImplTest {

    @Autowired
    private UsersDao usersDao;
    private User actualUser;
    private User expectedUser;

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void findByAge() throws Exception {
        expectedUser = new User(1L,19,"Alexey",new LinkedList<Book>(), new LinkedList<>());
        Book book = new Book(1L,"Master and Margarita",expectedUser);
        expectedUser.setBook(book);
        actualUser = usersDao.findByAge(19).get(0);
        boolean f = false;
        if (actualUser.compareTo(expectedUser)==1) {
            f = true;
        } else {
            f =false;
        }
        assertEquals(true,f);
    }

    @org.junit.Test
    public void find() throws Exception {
        expectedUser = new User(1L,19,"Alexey",new LinkedList<Book>(), new LinkedList<>());
        Book book = new Book(1L,"Master and Margarita",expectedUser);
        expectedUser.setBook(book);
        boolean f = false;
        actualUser = usersDao.find(1L);
        if (actualUser.compareTo(expectedUser)==1) {
            f = true;
        } else {
            f =false;
        }
        assertEquals(true,f);
    }


    @org.junit.Test
    public void insert() throws Exception {
        long expectedUserId = 2L;
        long actualUserId = usersDao.save(new User(2L,18,"Marat",new LinkedList<Book>(),new LinkedList<User>()));
        assertEquals(expectedUserId,actualUserId);
    }

    @org.junit.Test
    public void update() throws Exception {
        expectedUser = new User(1L,19,"Alexee",new LinkedList<Book>(), new LinkedList<>());
        Book book = new Book(1L,"Master and Margarita",expectedUser);
        expectedUser.setBook(book);
        actualUser = expectedUser;
        expectedUser.setAge(20);
        usersDao.update(actualUser);
        expectedUser.setAge(20);
        assertEquals(actualUser,expectedUser);
        expectedUser.setName("Alexey");
        expectedUser.setAge(19);
        usersDao.update(expectedUser);
    }

    @org.junit.Test
    public void delete() throws Exception {
        usersDao.delete(2L);
        User user = usersDao.find(2L);
        assertEquals(user,null);
    }

}