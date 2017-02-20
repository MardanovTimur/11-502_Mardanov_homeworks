package ru.itis.beans.scopes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ru.itis/context.xml");

        A a = (A)context.getBean("a");
        a.setaValue(10);
        A a2 = (A)context.getBean("a");
        System.out.println(a2.getaValue());
    }
}
