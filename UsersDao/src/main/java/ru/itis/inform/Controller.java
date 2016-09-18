package ru.itis.inform;

import java.io.FileNotFoundException;

/**
 * Created by Тимур on 06.09.2016.
 */
public class Controller {
    public static void main(String[] args) throws FileNotFoundException {
        User user1 = new User("Damir","00000","ad123456");
        User user2 = new User("Timur","00001","timur");
        User user3 = new User("Ilya","00002","stop_ham");

        UsersService usersService = new UsersService();

        usersService.addUser(user1);
        usersService.addUser(user2);
        usersService.addUser(user3);
        usersService.close();

//        System.out.print(usersService.isRegistered("65797273"));
    }
}
