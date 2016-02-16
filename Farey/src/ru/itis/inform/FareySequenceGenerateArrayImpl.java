package ru.itis.inform;

public class FareySequenceGenerateArrayImpl implements FareySequenceGenerateArray {

    private ListNodeImpl list = new ListNodeImpl();


    private int n;

    private int fixCount;
    private int index;


    public void Generate(int n) {
        Initialize();
        this.n = n;
        this.fixCount = 2;
        do {
            if (this.+ mas[index + 1].getB() <= this.n) {
                mas[fixCount] = new RationalNumber(mas[index].getA() + mas[index + 1].getA(), mas[index].getB() + mas[index + 1].getB());
                fixCount++;
                Shift(fixCount, mas, index);
            } else {
                index++;
            }

        } while (this.index < fixCount - 1);
    }

    public void Print() {
        for (int i = 0; i < this.fixCount; i++) {
            System.out.print(mas[i].getA() + "/" + mas[i].getB() + "  ");
        }
    }

    private void Initialize() {
        ListNodeImpl list = new ListNodeImpl();
        this.list.add(0, 1);
        this.list.add(1, 1);
    }




  /*  private void Shift(int fixCount, RationalNumber mas[], int index) {
       int buffer1 = mas[fixCount-1].getA();
       int buffer2 = mas[fixCount-1].getB();
        for (int i = fixCount-1; i>index+1; i--) {
            mas[i] = new RationalNumber(mas[i-1].getA(), mas[i - 1].getB());
        }
        mas[index+1] = new RationalNumber(buffer1, buffer2);
    }
}*/
}