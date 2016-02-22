package ru.itis.inform.Array;

/**
 * Created by Тимур on 17.02.2016.
 */
public class FareyArrayImpl implements FareyArray {

    RationalNumber mas[] = new RationalNumber[100];

    private int n;

    private int fixCount;
    private int index;

    public void generate(int n) {
        initialize();
        this.n = n;
        this.fixCount = 2;
        do {
            if (mas[index].getB() + mas[index + 1].getB() <= this.n) {
                mas[fixCount] = new RationalNumber(mas[index].getA() + mas[index + 1].getA(), mas[index].getB() + mas[index + 1].getB());
                fixCount++;
                shift(fixCount, mas, index);
            } else {
                index++;
            }
        } while (this.index < fixCount - 1);
    }

    public void print() {
        for (int i = 0; i < this.fixCount; i++) {
            System.out.print(mas[i].getA() + "/" + mas[i].getB() + "  ");
        }
    }

    public RationalNumber[] getArray() {
        return this.mas;
    }

    public void initialize() {
        mas[0] = new RationalNumber(0, 1);
        mas[1] = new RationalNumber(1, 1);
        for (int i = 2; i < 100; i++) {
            mas[i] = new RationalNumber();
        }
    }

    private void shift(int fixCount, RationalNumber mas[], int index) {
        int buffer1 = mas[fixCount - 1].getA();
        int buffer2 = mas[fixCount - 1].getB();
        for (int i = fixCount - 1; i > index + 1; i--) {
            mas[i] = new RationalNumber(mas[i - 1].getA(), mas[i - 1].getB());
        }
        mas[index + 1] = new RationalNumber(buffer1, buffer2);
    }
}