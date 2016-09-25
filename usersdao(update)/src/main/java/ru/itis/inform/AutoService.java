package ru.itis.inform;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;


public class AutoService extends JDBCAutoImpl {


    private AutoDao autoDao;

    public AutoService() throws FileNotFoundException {
        this.autoDao =  new AutoDaoImpl();
    }

    public void addAuto(Auto auto) throws FileNotFoundException {
        autoDao.save(auto);
    }



   /* public List findAll() throws FileNotFoundException, SQLException {
        return autoDao.findAll();
    }*/

    public void close(){
        autoDao.closePW();
        autoDao.closeSC();
    }
}
