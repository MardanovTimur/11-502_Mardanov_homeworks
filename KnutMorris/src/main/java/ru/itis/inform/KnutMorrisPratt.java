package ru.itis.inform;

/**
 * Created by Тимур on 26.02.2016.
 */
public class KnutMorrisPratt<T> {

    private String[] elements;

    public KnutMorrisPratt(T object) {
        for (int i = 0; i<10; i++) {
            this.elements[i] = new object();
        }
    }
}
