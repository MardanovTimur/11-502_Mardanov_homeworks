package ru.itis.inform.Human;

/**
 * Created by Тимур on 24.02.2016.
 */
public class Human {
    private int age;
    private String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Age: "+this.age+" name: "+this.name+" ";
    }

}
