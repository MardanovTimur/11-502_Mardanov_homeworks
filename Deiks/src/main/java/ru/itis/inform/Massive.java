package ru.itis.inform;

/**
 * Created by Тимур on 18.04.2016.
 */
public class Massive {
    private int value;
    boolean checkA = false;

    public void setValue(int value) {
        this.value = value;
    }

    public void setCheckA() {
        this.checkA = true;
    }

    public int getValue() {
        return value;
    }

    public boolean isCheckA() {
        return checkA;
    }
}
