package ru.itis.inform;

/**
 * Created by Тимур on 17.02.2016.
 */
public class PositiveNumbersSummator {
    public int summ(int a, int b) {
        if (a>=0 && b>=0) {
            return a+b;
        } else
            throw new IllegalArgumentException();
    }
}
