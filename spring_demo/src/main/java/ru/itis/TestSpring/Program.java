package ru.itis.TestSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Тимур on 14.02.2017.
 */
public class Program {
    public static void main(String[] args) {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("ru.itis/context.xml");
        Live live = beanFactory.getBean(Human.class);

        live.live();
    }
}
