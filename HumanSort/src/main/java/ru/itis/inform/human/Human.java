package ru.itis.inform.human;


/**
 * Created by Тимур on 24.02.2016.
 */
public class Human implements Comparable<Human> {
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
        return "Age: " + getAge() + " name: " + getName() + " ";
    }

    @Override
    public int compareTo(Human second) {

        int value = this.age - second.getAge();

        if (value > 0) {
            return 1;
        } else if (value < 0) {
            return -1;
        } else {
            return 0;
        }
    }

}
