package ru.itis.inform;

import org.h2.store.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.dao.impl.UsersDaoImpl;
import javax.sql.DataSource;

@Configuration
public class TestConfig {

    @Bean
    UsersDao usersDao() {
        return new UsersDaoImpl(dataSource());
    }

    DataSource dataSource() {
        EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).
            addScript("/DB/schema.sql").
            addScript("/DB/data.sql").build();
        return embeddedDatabase;
    }
}
