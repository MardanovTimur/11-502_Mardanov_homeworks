package ru.itis.inform.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.itis.inform.converter.UsersConverter;
import ru.itis.inform.dao.DataDao;
import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.dto.UserDto;
import ru.itis.inform.model.Data;
import ru.itis.inform.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Repository
public class UsersDaoImpl implements UsersDao {

    @Autowired
    DataDao dataDao;

    @Autowired
    Session session1;

    @Autowired
    @Qualifier(value = "sessionFactory")
    SessionFactory sessionFactory;

    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    public User getUserByName(String name) {
        Session session = session1;
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("name", name));
        return (User) criteria.uniqueResult();
    }

    public User get(int id) {
        Session session = session1;
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        return user;
    }

    public int saveObject(User object) {
        Session session = session1;
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        return object.getId();
    }

    public void delete(int id) {
        Session session = session1;
        session.beginTransaction();
        User object = session.load(User.class, id);
        session.delete(object);
        session.getTransaction().commit();
    }

    public User update(User object) {
        Session session = session1;
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
        Session session = session1;
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }

    public List<UserDto> findAllDto() {
        Session session = session1;
        Iterator<User> iterator = session.createCriteria(User.class).list().iterator();
        ArrayList<UserDto> userDtos = new ArrayList<>();
        while (iterator.hasNext()) {
            userDtos.add(UsersConverter.convertToUserDto(iterator.next()));
        }
        return userDtos;
    }


    public User findByToken(String token) {
        Session session = session1;
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("token", token));
        return (User) criteria.uniqueResult();
    }


    public User findByLogin(String login) {
        Session session = session1;
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", login));
        return (User) criteria.uniqueResult();
    }


    public User save(User user) {
        Session session = session1;
        session.beginTransaction();
        user.setPassword(encoder.encode(user.getPassword()));
        session.save(user);
        session.getTransaction().commit();
        return user;
    }


    public void updateToken(int id, String token) {
        Session session = session1;
        session.beginTransaction();
        User user = session.get(User.class, id);
        user.setToken(token);
        session.update(user);
        session.getTransaction().commit();
    }


    public List<User> findAll() {
        Session session = session1;
        ArrayList<User> arrayList = (ArrayList<User>) session.createCriteria(User.class).list();
        return arrayList;
    }

    @Override
    public boolean isExistToken(String token) {
        Session session = session1;
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("token", token));
        return (User) criteria.uniqueResult() != null;
    }


    Session getSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (Exception e) {
            return sessionFactory.openSession();
        }
    }
}
