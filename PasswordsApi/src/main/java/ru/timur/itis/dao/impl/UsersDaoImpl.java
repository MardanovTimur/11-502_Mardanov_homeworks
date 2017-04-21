package ru.timur.itis.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.timur.itis.converter.UsersConverter;
import ru.timur.itis.dao.DataDao;
import ru.timur.itis.dao.UsersDao;
import ru.timur.itis.dto.UserDto;
import ru.timur.itis.model.Data;
import ru.timur.itis.model.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by timur on 30.03.17.
 */
@Component
public class UsersDaoImpl implements UsersDao {

    @Autowired
    DataDao dataDao;

    @Autowired
    Session session1;

    @Autowired
    @Qualifier(value = "sessionFactory")
    SessionFactory sessionFactory;

    public User getUserByName(String name) {
        Session session = session1.getSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("name", name));
        return (User) criteria.uniqueResult();
    }

    public User get(int id) {
        Session session = session1.getSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        return user;
    }

    public int saveObject(User object) {
        Session session = session1.getSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        return object.getId();
    }

    public void delete(int id) {
        Session session = session1.getSession();
        session.beginTransaction();
        User object = session.load(User.class, id);
        session.delete(object);
        session.getTransaction().commit();
    }

    public User update(User object) {
        Session session = session1.getSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        return null;
    }

    public User addData(User user, Data data) {
        user.getDataList().add(data);
        data.setUser(user);
        update(user);
        dataDao.saveObject(data);
        return user;
    }


    public User findByUsername(String username) {
        Session session = session1.getSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }

    public List<UserDto> findAll() {
        Session session = session1.getSession();
        Iterator<User> iterator = session.createCriteria(User.class).list().iterator();
        ArrayList<UserDto> userDtos = new ArrayList<>();
        while (iterator.hasNext()) {
            userDtos.add(UsersConverter.convertToUserDto(iterator.next()));
        }
        return userDtos;
    }


    Session getSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (Exception e) {
            return sessionFactory.openSession();
        }
    }
}
