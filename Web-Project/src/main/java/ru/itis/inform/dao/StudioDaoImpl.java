package ru.itis.inform.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.inform.models.Producer;
import ru.itis.inform.models.Studio;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тимур on 27.10.2016.
 */
@Component
public class StudioDaoImpl implements StudioDao {

    //language=SQL
    private final String SQL_INSERT_STUDIO = "INSERT INTO studios (studio_name) VALUES ( ? )";

    //language=SQL
    private final String DELETE_FROM_STUDIO_BY_ID = "DELETE FROM studios WHERE id = ? ";

    //language=SQL
    private final String SELECT_ALL_STUDIOS = "SELECT * FROM studios";

    //language=SQL
    private final String SQL_SELECT_STUDIO_BY_NAME = "SELECT * FROM studios WHERE studio_name = ? ";

    //language=SQL
    private final String SQL_SELECT_STUDIO_BY_ID = "SELECT * FROM studios WHERE id = ? ";

    private JdbcTemplate jdbcTemplate;

    private RowMapper<Studio> rowMapper = new RowMapper<Studio>() {
        @Override
        public Studio mapRow(ResultSet rs, int i) throws SQLException {
            return new Studio(rs.getInt("id"), rs.getString("studio_name"));
        }
    };

    @Autowired
    public StudioDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean addStudio(Studio role) {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_STUDIO);
                preparedStatement.setString(1, role.getName());
                return preparedStatement;
            }
        });
        return true;
    }


    public Studio getStudioByFilmId(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_STUDIO_BY_ID, new Object[]{id}, rowMapper);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Studio getStudio(String name) {
        try{
            return jdbcTemplate.queryForObject(SQL_SELECT_STUDIO_BY_NAME,new Object[]{name}, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public LinkedList<Studio> getStudios() {
        try {
            List<Studio> list = jdbcTemplate.query(SELECT_ALL_STUDIOS,rowMapper);
            LinkedList<Studio> linkedList = new LinkedList<>();
            Iterator<Studio> iterator = list.iterator();
            while (iterator.hasNext()) {
                linkedList.add(iterator.next());
            }
            return linkedList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void deleteStudio(int id) {
        jdbcTemplate.update(DELETE_FROM_STUDIO_BY_ID,new Object[]{id});
    }
}
