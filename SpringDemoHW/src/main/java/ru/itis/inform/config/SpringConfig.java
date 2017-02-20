package ru.itis.inform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


/**
 * Created by Тимур on 15.02.2017.
 */

@Configuration
@ComponentScan("ru.itis.inform")
@PropertySource("ru.itis.inform/db.properties")
public class SpringConfig {

    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/autos");
        dataSource.setUsername("postgres");
        dataSource.setPassword("alisa654789");
        return dataSource;
    }

}
