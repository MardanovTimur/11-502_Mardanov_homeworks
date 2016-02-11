package ru.itis.inform;


/**
 * Created by Тимур on 10.02.2016.
 */
public class FareySequenceGenerateArrayImpl implements FareySequenceGenerateArray {

    RationalNumber mas[] = new RationalNumber[100];

    private int n;

    private int fixCount;
    private int index;

    public void Generate(int n) {
        Initialize();
        this.n = n;
        this.fixCount = 2;
        do {
            if (mas[index].getB() + mas[index+1].getB()<=this.n) {
                mas[fixCount].setA(mas[index].getA()+mas[index+1].getA());
                mas[fixCount].setB(mas[index].getB() + mas[index + 1].getB());
                fixCount++;
                Shift(fixCount, mas, index);
            } else {
                index++;
            }

        } while (this.index<n);
    }

    public void Print() {
        for (int i = 0; i < this.fixCount; i++) {
            System.out.print(mas[i].getA()+"/"+mas[i].getB()+"  ");
        }
    }

    private void Initialize() {
        mas[0] = new RationalNumber(0,1);
        mas[1] = new RationalNumber(1,1);
        for (int i = 2; i < 100; i++) {
            mas[i] = new RationalNumber(-1, -1);
        }
    }

    private void Shift(int fixCount, RationalNumber mas[], int index) {
       int buffer1 = mas[fixCount-1].getA();
       int buffer2 = mas[fixCount-1].getB();
        for (int i = fixCount-1; i>index+1; i--) {
            mas[i].setA(mas[i-1].getA());
            mas[i].setB(mas[i - 1].getB());
        }
        mas[index+1].setA(buffer1);
        mas[index+1].setB(buffer2);
    }
}
