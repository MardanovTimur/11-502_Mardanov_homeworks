package ru.itis.inform.dao;

import ru.itis.inform.models.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Тимур on 16.10.2016.
 */
public class RoleDaoImpl implements RoleDao {
    public Role getRole(String name) {
        System.out.println("Role name "+name);
        if (JDBConnection.getInstance().getConnection() != null && !name.equals("")) {
            String request = "SELECT * FROM roles WHERE role_name = ? ";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1, name);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                while (rs.next()) {
                    System.out.println("RoleDao");
                    System.out.println(rs.getInt("id")+" "+rs.getString("role_name"));
                    return new Role(rs.getInt("id"), rs.getString("role_name"));
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return null;
    }

    public List<Role> getGenres() {
        return null;
    }
}
