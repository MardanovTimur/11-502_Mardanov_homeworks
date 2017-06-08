package ru.itis.inform.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Timur Mardanov on 07.06.2017.
 * ITIS
 */
@Configuration
@EnableWebMvc
@ComponentScan("ru.itis.inform")
@Import(SpringConfig.class)
public class ApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                SpringConfig.class
        };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                SpringConfig.class
        };
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
