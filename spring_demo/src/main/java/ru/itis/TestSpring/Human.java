package ru.itis.TestSpring;

/**
 * Created by Тимур on 14.02.2017.
 */
public class Human implements Live{

    private Gun gun;

    private String name;
    private int age;
    private char sex;

    public Human() {
    }

    public Human(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Gun getGun() {

        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

    public void live() {
        gun.shoot();
    }

    public String voice() {
        return "Meo!";
    }
}
