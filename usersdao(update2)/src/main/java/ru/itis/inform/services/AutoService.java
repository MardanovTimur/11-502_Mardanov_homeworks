package ru.itis.inform.services;

import ru.itis.inform.Auto;
import ru.itis.inform.AutoDao;
import ru.itis.inform.AutoDaoImpl;
import ru.itis.inform.JDBC.JDBCAutoImpl;

import java.io.FileNotFoundException;


public class AutoService extends JDBCAutoImpl {


    private AutoDao autoDao;

    public AutoService() throws FileNotFoundException {
       // this.autoDao =  new AutoDaoImpl();
    }
//
//    public void addAuto(Auto auto) throws FileNotFoundException {
//        autoDao.save(auto);
//    }



   /* public List findAll() throws FileNotFoundException, SQLException {
        return autoDao.findAll();
    }*/

/*
    public void close(){
        autoDao.closePW();
        autoDao.closeSC();
    }
*/
}
