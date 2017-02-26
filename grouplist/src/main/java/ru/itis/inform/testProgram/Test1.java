package ru.itis.inform.testProgram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.Config;
import ru.itis.inform.dao.ContactsDao;
import ru.itis.inform.models.Contact;

import java.util.List;

/**
 * Created by Тимур on 25.02.2017.
 */
public class Test1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        ContactsDao contactsDao = applicationContext.getBean(ContactsDao.class);


        /*Contact contact = new Contact();
        contact.setFirstname("Vasya");
        contact.setLastname("Pashkin");
        contact.setEmail("pashkin@mail.ru");
        contact.setTelephone("8-800-555-35-35");
        contactsDao.addContact(contact);*/

        List<Contact> list = contactsDao.findAll();

        System.out.println("1");
    }
}
