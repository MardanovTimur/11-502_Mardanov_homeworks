package ru.itis.inform.testing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.dao.DataDao;
import ru.itis.inform.model.Data;
import ru.itis.inform.model.User;
import ru.itis.inform.spring.config.SpringConfig;

import java.util.ArrayList;

/**
 * Created by timur on 30.03.17.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UsersDao usersDao = applicationContext.getBean(UsersDao.class);
        User user = usersDao.get(1);
        DataDao dataDao = applicationContext.getBean(DataDao.class);
        Data data = new Data("github","github", user);
        ArrayList<Data> arrayList =  new ArrayList<Data>();
        arrayList.add(data);
        user.setDataList(arrayList);
        usersDao.update(user);
        dataDao.saveObject(data);
        System.out.println(1);
    }
}
