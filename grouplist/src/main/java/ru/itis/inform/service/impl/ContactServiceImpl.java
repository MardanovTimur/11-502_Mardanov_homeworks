package ru.itis.inform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.inform.dao.ContactsDao;
import ru.itis.inform.models.Contact;
import ru.itis.inform.service.ContactService;

import java.util.List;


@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactsDao contactsDao;

    @Transactional
    public long addContact(Contact contact) {
        return contactsDao.addContact(contact);
    }
    @Transactional
    public List<Contact> allContacs() {
        return contactsDao.findAll();
    }

    @Transactional
    public boolean remove(Long id) {
        return contactsDao.removeContact(id);
    }
}
