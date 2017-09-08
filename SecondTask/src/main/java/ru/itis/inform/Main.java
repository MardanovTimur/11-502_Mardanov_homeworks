package ru.itis.inform;

/**
 * Created by Timur Mardanov on 08.06.2017.
 * ITIS
 */
public class Main {
    public static void main(String[] args) {
        Quad quad = new Quad(1,4,-4);
        quad.searchXY();
        String x1 = quad.getX1();
        String x2 = quad.getX2();
    }
}
