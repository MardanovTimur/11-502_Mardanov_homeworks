package ru.itis.inform;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class UsersDaoImpl implements UsersDao {
    private File file = new File("C:\\Android\\list.txt");
    private Scanner sc = new Scanner(new File(file.getPath()));


    public UsersDaoImpl() throws FileNotFoundException {
    }

    public List<User> findAll() throws FileNotFoundException {
        List<User> userList = new LinkedList<User>();
        String users;

        if (sc.hasNextLine()) {
            users = sc.nextLine();
        } else
            return null;
        String user[] = users.split(" ");
        User newUser = new User();
        for (int i = 0; i < user.length / 3; i++) {
            newUser.setName(user[i * 3]);
            newUser.setId(user[i * 3 + 1]);
            newUser.setPassword(user[i * 3 + 2]);
            userList.add(newUser);
            newUser = new User();
        }
        return userList;
    }

    public void save(User user) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(file.getPath()));
        int hashCode = user.hashCode();
        String information = user.getName() + " " + hashCode + " " + user.getPassword() + " ";
        pw.print(information);
    }

    public User find(String string, int definition) throws FileNotFoundException {
        String users = sc.nextLine();
        String user[] = users.split(" ");
        String id_s;
        id_s = "";
        id_s += string;
        User newUser = null;
        for (int i = 0; i < user.length / 3; i++) {
            if (id_s.equals(user[i * 3 + definition])) {
                newUser = new User(user[i * 3], user[i * 3 + 1], user[i * 3 + 2]);
            }
        }
        if (newUser != null) {
            return newUser;
        } else
            return null;
    }

    public void closePW() {
        PrintWriter pw = null;
        pw.close();
    }

    public void closeSC() {
        this.sc.close();
    }
}


