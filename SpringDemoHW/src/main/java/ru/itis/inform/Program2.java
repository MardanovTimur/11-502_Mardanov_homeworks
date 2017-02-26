package ru.itis.inform;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.config.SpringConfig;
import ru.itis.inform.dao.BookDao;
import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.model.Book;
import ru.itis.inform.model.User;
import ru.itis.inform.service.UserService;

import java.util.List;

/**
 * Created by Тимур on 18.02.2017.
 */
public class Program2 {
    public static void main(String[] args) {
        ApplicationContext beanF = new AnnotationConfigApplicationContext(SpringConfig.class);
        UsersDao usersDao = (UsersDao) beanF.getBean("hibernate.users.dao");
        BookDao bookDao = (BookDao)beanF.getBean("hibernate.book.dao");
        //usersDao.findAll();
        //List<User> list = usersDao.findByAge(19);
        //User user = usersDao.find(1L);
        //System.out.println("Ok");

        //List<Book> listBooks = bookDao.getAllBooksByUserId(1L);
        /*User user = usersDao.find(1L);
        Book book = new Book();
        book.setName("War and Live");
        book.setUser(user);
        bookDao.save(book);*/

        //book.setName("War of Live");
        //bookDao.update(book);
        //bookDao.delete(6L);
        //UserService userService = beanF.getBean(UserService.class);
        //List<Book> books = userService.getAllBooks();

        //List<User> list = usersDao.findByAge(21);
        //User user = usersDao.find(1L);
        List<User> list = usersDao.findAll();

        /*User user = new User();
        user.setId(1L);
        user.setAge(5);
        user.setName("Nursil");
        usersDao.update(user);

        User newUser = new User();
        newUser.setAge(12);
        newUser.setName("AlexeyDavydov");
        usersDao.save(newUser);*/

        UserService userService = beanF.getBean(UserService.class);

        //userService.addFriend(1L,3L);

        boolean f = usersDao.addFriend(1L,4L);

        System.out.println(1);

    }
}
