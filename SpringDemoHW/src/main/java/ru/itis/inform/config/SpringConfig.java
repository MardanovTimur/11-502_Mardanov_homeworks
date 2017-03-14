package ru.itis.inform.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.itis.inform.controllers.UsersController;
import ru.itis.inform.dao.hibernate.HibernateBookDao;

import javax.sql.DataSource;


/**
 * Created by Тимур on 15.02.2017.
 */

@Configuration
@ComponentScan("ru.itis.inform")
@PropertySource("classpath:ru.itis.inform/db.properties")
public class SpringConfig {

    @Autowired
    Environment environment;

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.addResource("ru.itis.inform/hibernate/Book.hbm.xml");
        builder.addResource("ru.itis.inform/hibernate/User.hbm.xml");
        builder.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQL82Dialect");
        return builder.buildSessionFactory();
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/autos");
        dataSource.setUsername("postgres");
        dataSource.setPassword("alisa654789");
        return dataSource;
    }

    @Bean
    public ViewResolver viewResolver() {
        ViewResolver viewResolver = new InternalResourceViewResolver("/",".jsp");
        return viewResolver;
    }

    @Bean(name = "/all-users")
    public Controller controller() {
        return new UsersController();
    }


}
