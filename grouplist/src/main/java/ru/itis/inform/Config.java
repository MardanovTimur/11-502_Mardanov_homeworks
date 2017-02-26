package ru.itis.inform;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import ru.itis.inform.models.Contact;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import java.sql.DriverManager;

/**
 * Created by Тимур on 25.02.2017.
 */

@Configuration
@ComponentScan("ru.itis.inform")
public class Config {
    @Bean
    public HibernateTransactionManager transactionManager(){
        return new HibernateTransactionManager(sessionFactory());
    }

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder factoryBean = new LocalSessionFactoryBuilder(dataSource());
        //factoryBean.setProperty("configLocation","hibernate.cfg.xml");
        factoryBean.addAnnotatedClass(Contact.class);
        factoryBean.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQL82Dialect");
        return factoryBean.buildSessionFactory();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("alisa654789");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/memory");
        return dataSource;
    }

}
