package ru.itis.inform.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.ContactsDao;
import ru.itis.inform.models.Contact;

import java.util.List;

/**
 * Created by Тимур on 25.02.2017.
 */
@Repository
public class ContactsDaoImpl implements ContactsDao {

    @Autowired
    SessionFactory sessionFactory;

    public Long addContact(Contact contact) {
        Session session = getSession();
        try {
            session.beginTransaction();
            session.save(contact);
            session.getTransaction().commit();
            return contact.getId();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public List<Contact> findAll() {
        Session session = getSession();
        return session.createQuery("from Contact").list();
    }

    public boolean removeContact(Long id) {
        Session session = getSession();
        try {
            Contact contact = session.get(Contact.class, id);
            if (contact!=null) {
                session.beginTransaction();
                session.remove(contact);
                session.getTransaction().commit();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    Session getSession(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException s) {
            session = sessionFactory.openSession();
        }
        return session;
    }
}
