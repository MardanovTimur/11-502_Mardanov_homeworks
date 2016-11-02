package ru.itis.inform;

import ru.itis.inform.dao.JDBConnection;
import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.services.UserService;
import ru.itis.inform.utils.Hash;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Тимур on 07.10.2016.
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        String password = "admin";
        System.out.println(Hash.getMd5Apache(password));

        UserService userService = ServiceFactory.getInstance().getUserService();
        userService.add("Aaaaa","aaaaa","password","password",false);
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = dateFormat.parse("9.04.2000");
        long time = date.getTime();
        System.out.println(time);

        String s = "Leonardo Dicaprio,";
        String[] s1 = s.split(",");
        System.out.println(s1.length);
    }
}
