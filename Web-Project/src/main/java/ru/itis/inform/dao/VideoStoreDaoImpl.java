package ru.itis.inform.dao;

import ru.itis.inform.models.Film;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by Тимур on 16.10.2016.
 */
public class VideoStoreDaoImpl implements VideoStoreDao {
    public String add(Film film) throws SQLException {
        ResultSet rs = null;
        if (JDBConnection.getInstance().getConnection() != null && film != null) {
            String request = "INSERT INTO films (film_name, film_producer, film_studio,film_year,description,remark,img_url) VALUES (?,?,?,?,?,?,?)";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1, film.getName());
                JDBConnection.statement.setInt(2, film.getProducer());
                JDBConnection.statement.setInt(3, film.getStudio());
                JDBConnection.statement.setDate(4, film.getDate());
                JDBConnection.statement.setString(5, film.getDescription());
                JDBConnection.statement.setInt(6, film.getRemark());
                JDBConnection.statement.setString(7, film.getImageURL());
                //Todo
                String warnings = "";
                rs = JDBConnection.getInstance().getStatement().executeQuery();
                while (rs.next()) {
                    SQLWarning sqlWarning = null;

                    sqlWarning = rs.getWarnings();

                    warnings = "";
                    if (sqlWarning != null) {
                        System.out.println("Warning");
                        while (sqlWarning != null) {
                            warnings += sqlWarning.getMessage() + "<br>";

                            System.out.println(sqlWarning.getMessage());
                            sqlWarning.getNextWarning();
                        }
                    }
                }
                return "";
                //JDBConnection.getInstance().getStatement().execute();
            } catch (SQLException e) {
                String er = e.getMessage();
                e.printStackTrace();
                return er.split("\n")[0];
            }
        }

        return "Er";
    }

    public int getId(String name) {
        if (JDBConnection.getInstance().getConnection() != null && !name.equals("")) {
            String request = "SELECT id FROM films WHERE film_name = ? ";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1, name);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                while (rs.next()) {
                    return rs.getInt("id");
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return 0;
    }

    public void delete(String id) {
        if (JDBConnection.getInstance().getConnection() != null && !id.equals("")) {
            String request = "DELETE FROM films WHERE id = ?";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1, Integer.parseInt(id));
                JDBConnection.getInstance().getStatement().executeUpdate();
            } catch (SQLException es) {
                es.printStackTrace();
            }
        }
    }

    public LinkedList<Film> getAllFilms() {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT * FROM films ORDER BY id ASC";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                LinkedList<Film> linkedList = new LinkedList<Film>();
                Film film = null;
                while (rs.next()) {
                    try {
                        film = new Film(rs.getInt("id"), rs.getString("film_name"), rs.getInt("film_producer"), rs.getInt("film_studio"), rs.getString("description"), rs.getInt("remark"), rs.getDate("film_year"), rs.getString("img_url"));
                    } catch (Exception e) {
                        film = null;
                        e.printStackTrace();
                    }
                    linkedList.addFirst(film);
                }
                return linkedList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Film getFilm(int id) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT * FROM films WHERE id = ? ";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1, id);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                Film film = null;
                while (rs.next()) {
                    try {
                        film = new Film(rs.getInt("id"), rs.getString("film_name"), rs.getInt("film_producer"), rs.getInt("film_studio"), rs.getString("description"), rs.getInt("remark"), rs.getDate("film_year"), rs.getString("img_url"));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                    return film;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public String updateFilm(int nid, String nname, int nstudio, Date nyear, int nproducer, String ndescription, int nremark,
                             String nurl, String[] nroles, String[] ngenres, int nquantity, int nprice) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT * FROM updateFilm(?,?,?,?,?,?,?,?,?,?,?,?);";
            try {
                Array roles = JDBConnection.getConnection().createArrayOf("varchar",nroles);
                Array genres = JDBConnection.getConnection().createArrayOf("varchar", ngenres);
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1,nid);
                JDBConnection.statement.setString(2,nname);
                JDBConnection.statement.setInt(3,nstudio);
                JDBConnection.statement.setDate(4,nyear);
                JDBConnection.statement.setInt(5,nproducer);
                JDBConnection.statement.setString(6,ndescription);
                JDBConnection.statement.setInt(7,nremark);
                JDBConnection.statement.setString(8,nurl);
                JDBConnection.statement.setArray(9, roles);
                JDBConnection.statement.setArray(10, genres);
                JDBConnection.statement.setInt(11,nquantity);
                JDBConnection.statement.setInt(12,nprice);

                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();

                while (rs.next()) {
                    return rs.getString(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "Error";
    }

    @Override
    public LinkedList<Film> getSearhFilms(String s) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT * FROM getSearchFilms(?)";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1,s);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                String[] ids = new String[300];
                while (rs.next()) {
                    ids = rs.getString(1).split(" ");
                }
                LinkedList<Film> linkedList = new LinkedList<Film>();
                for (String id :
                        ids) {
                    if (!id.equals(""))
                    linkedList.add(getFilm(Integer.parseInt(id)));
                }
                return linkedList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}