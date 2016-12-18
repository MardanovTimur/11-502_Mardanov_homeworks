package ru.itis.inform.factories;

import ru.itis.inform.services.UserService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Тимур on 02.11.2016.
 */
//Фабрика для упр. сервисами
public class ServiceFactory {
    private static ServiceFactory instance;
    private Properties properties;
    private UserService userService;

    static {
        instance = new ServiceFactory();
    }

    private ServiceFactory() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\Web-Project\\src\\main\\resources\\service.properties"));

            //UserService
            String userService = properties.getProperty("userservice.class");
            this.userService = (UserService)Class.forName(userService).newInstance();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }
}
