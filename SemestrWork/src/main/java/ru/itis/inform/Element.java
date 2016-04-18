package ru.itis.inform;

/**
 * Created by Тимур on 30.03.2016.
 */
public class Element {
    private int indexX;
    private int indexY;
    private int value;

    public Element(int value, int indexX, int indexY) {
        this.indexX = indexX;
        this.indexY = indexY;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Element() {
    }

    public void setValue(int value) {

        this.value = value;
    }
}
