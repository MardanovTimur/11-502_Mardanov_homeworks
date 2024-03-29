package ru.itis.inform.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.PlatformTransactionManager;
import ru.itis.inform.model.*;
import ru.itis.inform.security.details.UserDetailsServiceImpl;
import ru.itis.inform.security.filter.TokenAuthFilter;
import ru.itis.inform.security.provider.TokenAuthenticationProvider;

import javax.servlet.Filter;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@ComponentScan("ru.itis.inform")
@EnableJpaRepositories("ru.itis.inform.dao")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public Session session() {
        try {
            return sessionFactory().getCurrentSession();
        } catch (Exception e) {
            return sessionFactory().openSession();
        }
    }

    @Bean
    @Qualifier("dataSourse")
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/passwords_api");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("alisa654789");
        return driverManagerDataSource;
    }

    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory(){
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.addAnnotatedClass(User.class);
        builder.addAnnotatedClass(Data.class);
        builder.addAnnotatedClasses(Booking.class);
        builder.addAnnotatedClasses(Seance.class);
        builder.addAnnotatedClasses(Film.class);
        builder.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
        return builder.buildSessionFactory();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic().disable()
                .formLogin().disable()
                .csrf().disable()
                .authorizeRequests().anyRequest().permitAll().and();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(tokenAuthenticationProvider());
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public AuthenticationProvider tokenAuthenticationProvider() {
        return new TokenAuthenticationProvider();
    }

    @Bean
    public Filter tokenAuthenticationFilter(AuthenticationManager authenticationManager) {
        return new TokenAuthFilter(authenticationManager);
    }

    @Bean
    PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();

        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setPackagesToScan("ru.itis.inform.model");
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        return adapter;
    }
}
