package ru.itis.inform.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.BookDao;
import ru.itis.inform.model.Book;
import ru.itis.inform.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Тимур on 22.02.2017.
 */

@Component("hibernate.book.dao")
public class HibernateBookDao implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Book> getAllBooksByUserId(Long id) {
        Session session = getSession();
        User user = session.get(User.class, id);
        if (user != null) {
            session.beginTransaction();
            List<Book> bookList = user.getBooks();
            session.getTransaction().commit();
            return bookList;
        } else {
            return new ArrayList<Book>();
        }
    }

    public Long save(Book book) {
        Session session = getSession();
        Long id = book.getId();
        if (id != null && session.get(User.class, id) == null) {
            session.beginTransaction();
            session.saveOrUpdate(book);
            session.flush();
            session.getTransaction().commit();
            return book.getId();
        } else
            return null;
    }

    public void update(Book book) {
        Session session = getSession();
        session.beginTransaction();
        session.saveOrUpdate(book);
        session.getTransaction().commit();
    }

    public Book find(Long id) {
        Session session = getSession();
        Book book = session.get(Book.class, id);
        return book;
    }

    public void delete(Long id) {
        Session session = getSession();
        Book book = session.get(Book.class, id);
        if (book != null) {
            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();
        }
    }

    public List<Book> findAll() {
        Session session = getSession();
        List<Book> list = session.createQuery("from Book", Book.class).list();
        return list;
    }

    private Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException c) {
            session = sessionFactory.openSession();
        }
        return session;
    }

}
