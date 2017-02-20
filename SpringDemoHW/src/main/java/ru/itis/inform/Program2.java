package ru.itis.inform;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.config.SpringConfig;
import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.model.User;

import java.util.List;

/**
 * Created by Тимур on 18.02.2017.
 */
public class Program2 {
    public static void main(String[] args) {
        ApplicationContext beanF = new AnnotationConfigApplicationContext(SpringConfig.class);
        UsersDao usersDao = beanF.getBean(UsersDao.class);
        //usersDao.findAll();
        //List<User> list = usersDao.findByAge(19);
        User user = usersDao.find(1L);
        System.out.println("Ok");

    }
}
