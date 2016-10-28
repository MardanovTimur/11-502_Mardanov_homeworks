package ru.itis.inform.dao;

import ru.itis.inform.models.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тимур on 16.10.2016.
 */
public class RoleDaoImpl implements RoleDao {
    public boolean addRole(Role role) {
        if (JDBConnection.getInstance().getConnection()!=null && role!=null) {
            String request = "INSERT INTO roles (role_name) VALUES ( ? )";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1,role.getName());
                JDBConnection.getInstance().getStatement().executeUpdate();
            } catch (SQLException s) {
                s.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public Role getRole(String name) {
        if (JDBConnection.getInstance().getConnection() != null && !name.equals("")) {
            String request = "SELECT * FROM roles WHERE role_name = ? ";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1, name);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                while (rs.next()) {
                    return new Role(rs.getInt("id"), rs.getString("role_name"));
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return null;
    }

    public List<Role> getGenres() {
        List<Role> roleList = new LinkedList<Role>();
        if (JDBConnection.getInstance().getConnection() != null ) {
            String request = "SELECT * FROM roles";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                while (rs.next()) {
                    roleList.add(new Role(rs.getInt("id"), rs.getString("role_name")));
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                return null;
            }
        }
        return roleList;
    }
}
