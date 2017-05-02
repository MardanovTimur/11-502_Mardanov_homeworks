package ru.itis.theory;

/**
 * Created by alisa on 17.04.2017.
 */
public class Node {

    private Character key;

    private boolean isNegative;

    private boolean isBound = true;

    public Node() {
    }

    public static String getBinary(int i) {
        String binCode = "";
        while (i > 0) {
            binCode = binCode.concat(String.valueOf(i % 2));
            i = i / 2;
        }

        while (binCode.length()!=4) {
            binCode = binCode.concat("0");
        }

        return new StringBuilder(binCode).reverse().toString();
    }

    public Node(char key, boolean isNegative) {
        this.key = key;
        this.isNegative = isNegative;
    }

    public Node(Character key, boolean isNegative, boolean isBound) {
        this.key = key;
        this.isNegative = isNegative;
        this.isBound = isBound;
    }

    public boolean getNegative() {
        return isNegative();
    }

    public Character getKey() {
        return key;
    }

    public void setKey(Character key) {
        this.key = key;
    }

    public boolean isNegative() {
        return isNegative;
    }

    public void setNegative(boolean negative) {
        isNegative = negative;
    }

    public boolean isBound() {
        return isBound;
    }

    public void setBound(boolean bound) {
        isBound = bound;
    }
}
