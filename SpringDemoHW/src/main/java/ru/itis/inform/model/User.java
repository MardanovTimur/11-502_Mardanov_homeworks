package ru.itis.inform.model;

import javax.jws.soap.SOAPBinding;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Тимур on 15.02.2017.
 */
public class User implements Comparable<User> {
    private Long id;
    private int age;
    private String name;
    private List<Book> books;
    private List<User> friends;

    public User() {
    }

    public User(Long id, int age, String name, List<Book> books, List<User> friends) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.books = books;
        this.friends = friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<User> getFriends() {

        return friends;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setBook(Book book) {
        this.books.add(book);
    }

    public Long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }


    public int compareTo(User o1) {
        if (o1.getId().equals(this.getId())) {
            if (o1.getAge() == this.getAge()) {
                if (o1.getName().equals(this.getName())) {
                    try {
                        if (o1.getBooks().get(0).getName().equals(this.getBooks().get(0).getName())) {
                            return 1;
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Book is null");
                    }
                }
            }
        }
        return 0;
    }
}
