package ru.itis.TestSpring;

public class Gun {

    private int diameter;
    private String name;

    public Gun() {
    }

    public void shoot() {
        System.out.println(getName()+" = = = Piu-Piu-Piu!");
    }

    public Gun(int diameter, String name) {
        this.diameter = diameter;
        this.name = name;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiameter() {

        return diameter;
    }

    public String getName() {
        return name;
    }
}
