package ru.itis.inform.services;

import ru.itis.inform.dao.RoleFilmDao;
import ru.itis.inform.dao.RoleFilmDaoImpl;
import ru.itis.inform.models.RoleFilm;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Тимур on 19.10.2016.
 */
public class RolesFilmServiceImpl implements RolesFilmService {
    RoleFilmDao roleFilmDao = new RoleFilmDaoImpl();
    public boolean addRolesOnFilm(String roles, int filmId) {
        RoleServices roleServices = new RoleServicesImpl();
        LinkedList<RoleFilm> rolesfilms = new LinkedList<RoleFilm>();
        System.out.println("RolesFilmServiceImpl" + roles);
        String[] rolesAllSplitted = roles.split(",");
        for (String role : rolesAllSplitted) {
            try {
                RoleFilm roleFilm = new RoleFilm(filmId, roleServices.getRole(role).getId());
                rolesfilms.add(roleFilm);
            } catch (NullPointerException e){
                return false;
            }
        }
        RoleFilmDao roleFilmDao = new RoleFilmDaoImpl();
        for (int i = 0; i<rolesfilms.size(); i++) {
            boolean f = roleFilmDao.addRolesOnFilm(rolesfilms.get(i).getRoleId(),rolesfilms.get(i).getFilmId());
            if (!f) {return false;}
        }
        return true;
    }

    public LinkedList getRoleIdByFilmId(int id) {
        return roleFilmDao.getRoleIdByFilmId(id);
    }
}
