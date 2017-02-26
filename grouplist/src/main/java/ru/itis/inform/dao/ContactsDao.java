package ru.itis.inform.dao;

import ru.itis.inform.models.Contact;

import java.util.List;

/**
 * Created by Тимур on 25.02.2017.
 */
public interface ContactsDao {

    Long addContact(Contact contact);

    List<Contact> findAll();

    boolean removeContact(Long id);

}
