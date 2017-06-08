package ru.itis.inform.config;

import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.itis.inform.aspects.GreetingAspect;

/**
 * Created by Timur Mardanov on 07.06.2017.
 * ITIS
 */
@Configuration
@ComponentScan(value = "ru.itis.inform")
public class SpringConfig {

    @Bean
    @Scope(value = "singleton")
    public GreetingAspect greetingAspect() {
        return new GreetingAspect("This is first aspect in java");
    }

}
