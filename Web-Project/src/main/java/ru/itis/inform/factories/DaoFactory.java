package ru.itis.inform.factories;

import ru.itis.inform.dao.CommentsDao;
import ru.itis.inform.dao.FilmExistanceDao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Тимур on 02.11.2016.
 */
public class DaoFactory {
    private static DaoFactory instance;
    private CommentsDao commentsDao;
    private FilmExistanceDao filmExistanceDao;
    private Properties properties;
    static {
        instance = new DaoFactory();
    }

    private DaoFactory() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\Web-Project\\src\\main\\resources\\dao.properties"));

            String commentsDaoImpl = properties.getProperty("commentdao.class");
            String filmExistanceDaoImpl = properties.getProperty("filmexistancedaoimpl.class");

            commentsDao = (CommentsDao)Class.forName(commentsDaoImpl).newInstance();
            filmExistanceDao = (FilmExistanceDao)Class.forName(filmExistanceDaoImpl).newInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public CommentsDao getCommentsDao(){
        return commentsDao;
    }

    public FilmExistanceDao getFilmExistanceDao() {
        return filmExistanceDao;
    }
}
