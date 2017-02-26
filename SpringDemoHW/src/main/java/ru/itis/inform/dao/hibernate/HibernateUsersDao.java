package ru.itis.inform.dao.hibernate;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.model.User;

import javax.jws.soap.SOAPBinding;
import java.util.*;

/**
 * Created by Тимур on 23.02.2017.
 */
@Component("hibernate.users.dao")
public class HibernateUsersDao implements UsersDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> findByAge(int age) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("age", age));
        List<User> userList = criteria.list();
        return userList;
    }

    @Override
    public boolean addFriend(Long fId, Long sId) {
        if (fId.longValue() != sId.longValue()) {
            Session session = getSession();
            User user1 = session.get(User.class, fId);
            User user2 = session.get(User.class, sId);
            if (user1 != null && user2 != null) {
                if (!isFriends(user1.getId(), user2.getId())) {
                    session.beginTransaction();
                    user1.getFriends().add(user2);
                    user2.getFriends().add(user1);
                    session.saveOrUpdate(user1);
                    session.saveOrUpdate(user2);
                    session.flush();
                    session.getTransaction().commit();
                    return true;
                } else {
                    System.out.println("They are already friends!");
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean isFriends(Long fId, Long sId) {
        Session session = getSession();
        User userFirst = session.get(User.class, fId);
        List<User> firstUserFriends = userFirst.getFriends();
        Iterator<User> iterator = firstUserFriends.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().longValue() == sId.longValue()) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Long save(User user) {
        Session session = getSession();
        session.beginTransaction();
        Long id = user.getId();
        if (id == null) {
            session.saveOrUpdate(user);
            session.flush();
            session.getTransaction().commit();
        } else {
            session.getTransaction().commit();
            update(user);
        }
        return user.getId();
    }

    @Override
    public void update(User user) {
        Session session = getSession();
        session.beginTransaction();
        if (user.getId() != null) {
            session.saveOrUpdate(user);
            session.flush();
            session.getTransaction().commit();
        } else {
            System.out.println("UPDATE_USER: Haven't id of user!");
        }
    }

    @Override
    public User find(Long id) {
        Session session = getSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void delete(Long id) {
        Session session = getSession();
        User user = session.get(User.class, id);
        if (user != null) {
            session.beginTransaction();
            session.delete(user);
            session.flush();
            session.getTransaction().commit();
        } else {
            System.out.println("DELETE_USER: null id");
        }
    }

    @Override
    public List<User> findAll() {
        Session session = getSession();
        List<User> userList = session.createQuery("from User", User.class).list();
        return userList;
    }

    public Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session;
    }
}
