package ru.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.service.UsersService;

public class Program {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ru.itis/context.xml");

        UsersService service = (UsersService)context.getBean("usersService");
        System.out.println(service.getNameOfUser(1));
    }
}
