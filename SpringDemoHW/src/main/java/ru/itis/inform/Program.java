package ru.itis.inform;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.inform.config.SpringConfig;
import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.model.User;
import ru.itis.inform.service.UserService;

import java.applet.AppletContext;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тимур on 15.02.2017.
 */
public class Program {
    public static void main(String[] args) {
        //ApplicationContext beanFactory = new ClassPathXmlApplicationContext("ru.itis.inform/context.xml");
        ApplicationContext beanFactory = new AnnotationConfigApplicationContext(SpringConfig.class);

        UsersDao usersDao = beanFactory.getBean(UsersDao.class);

        User user = usersDao.find(1L);

        System.out.println(user.getId() + " " + user.getName() + " " + user.getAge());

        UserService userService = beanFactory.getBean(UserService.class);

        System.out.println(userService.isRegistered("Timur"));

        List<User> s = usersDao.findByAge(18);
        System.out.println(s.get(0).getName());

        System.out.println("Привет я идия на ubuntu");
        //User newUser = new User(4L,20,"Marat");

        //long marselsID = usersDao.save(newUser);
        //System.out.println(marselsID);

        //usersDao.update(newUser);

        //usersDao.delete(5L);
    }
}
