package ru.itis.inform.service;

import org.springframework.stereotype.Service;

/**
 * Created by Timur Mardanov on 07.06.2017.
 * ITIS
 */
@Service("greetingService")
public class GreetingService {
    public static final String HELLO_FROM_GREETING_SERVICE = "Hello from Greeting Service";

    public String sayHello() {
        System.out.println("Service beginning");
        return HELLO_FROM_GREETING_SERVICE;
    }
}
