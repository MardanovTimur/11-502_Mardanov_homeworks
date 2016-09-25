package ru.itis.inform;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class UsersDaoImpl implements UsersDao {
    private File file;
    private Scanner sc;
    private PrintWriter pw;

    public UsersDaoImpl() throws FileNotFoundException {
    }

    public List findAll() throws FileNotFoundException {
        List list = new LinkedList();
        String elements;

        this.file = new File("C:\\Android\\list.txt");
        this.sc = new Scanner(new File(file.getPath()));

        if (sc.hasNextLine()) {
            elements = sc.nextLine();
        } else
            return null;

        String element[] = elements.split(" ");

        User newUser = new User();
        for (int i = 0; i < element.length / 5; i++) {
            newUser.setName(element[i * 5]);
            newUser.setId(element[i * 5 + 1]);
            newUser.setPassword(element[i * 5 + 2]);
            newUser.setYear(Integer.parseInt(element[i * 5 + 3]));
            newUser.setCity(element[i * 5 + 4]);
            list.add(newUser);
            newUser = new User();
        }
        return list;
    }

    public void save(User user) throws FileNotFoundException {
        this.file = new File("C:\\Android\\auto.txt");
        this.sc = new Scanner(new File(file.getPath()));
        String textInScanner;
        if (sc.hasNextLine()) {
            textInScanner = sc.nextLine();
        } else {
            textInScanner = "";
        }
        PrintWriter pw = new PrintWriter(new File(file.getPath()));
        int hashCode = user.hashCode();
        String information = textInScanner + user.getName() + " " + hashCode + " " + user.getPassword() + " " + user.getYear() + " " + user.getCity();
        pw.print(information);
    }

    public User find(String string, int definition) throws FileNotFoundException {
        String users = sc.nextLine();
        String user[] = users.split(" ");
        String id_s;
        id_s = "";
        id_s += string;
        User newUser = null;
        for (int i = 0; i < user.length / 5; i++) {
            if (id_s.equals(user[i * 5 + definition])) {
                newUser = new User(user[i * 5], user[i * 5 + 1], user[i * 5 + 2], Integer.parseInt(user[i * 5 + 3]),user[i * 5 + 4] );
            }
        }
        if (newUser != null) {
            return newUser;
        } else
            return null;
    }

    public void closePW() {
        this.pw.close();
    }

    public void closeSC() {
        this.sc.close();
    }
}


