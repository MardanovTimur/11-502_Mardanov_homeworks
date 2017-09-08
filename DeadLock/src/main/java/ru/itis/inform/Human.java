package ru.itis.inform;

public class Human {
    private int age;
    private String name;
    private Card card;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Human(String name) {
        this.name = name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
