package ru.itis.inform.service;

import ru.itis.inform.models.Contact;

import java.util.List;

/**
 * Created by Тимур on 25.02.2017.
 */
public interface ContactService {

    long addContact(Contact contact);

    List<Contact> allContacs();

    boolean remove(Long id);

}
