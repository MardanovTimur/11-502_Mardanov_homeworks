package ru.itis.inform.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.DataDao;
import ru.itis.inform.model.Data;

/**
 * Created by timur on 30.03.17.
 */
@Repository
public class DataDaoImpl implements DataDao {

    @Autowired
    @Qualifier("sessionFactory")
    SessionFactory sessionFactory;

    @Autowired
    Session session1;

    public Data get(int id) {
        Session session = session1;
        session.beginTransaction();
        Data user = session.get(Data.class, id);
        session.getTransaction().commit();
        return user;
    }

    public int saveObject(Data object) {
        Session session = session1;
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        return object.getId();
    }

    public void delete(int id) {
        Session session = session1;
        session.beginTransaction();
        Data object = session.load(Data.class, id);
        session.delete(object);
        session.getTransaction().commit();
    }

    public Data update(Data object) {
        Session session = session1;
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        return null;
    }


    Session getSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (Exception e) {
            return sessionFactory.openSession();
        }
    }
}
