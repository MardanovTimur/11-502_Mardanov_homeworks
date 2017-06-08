package ru.itis.inform;

/**
 * Created by Timur Mardanov on 08.06.2017.
 * ITIS
 */
public class RationalFrac implements Comparable<RationalFrac> {
    private int nominator = 1;
    private int denominator = 1;
    private int theWholePart = 0;

    public RationalFrac(int nominator, int denominator, int theWholePart) {
        this.nominator = nominator;
        this.denominator = denominator;
        this.theWholePart = theWholePart;
    }

    public RationalFrac(int nominator, int denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
    }

    public RationalFrac(int theWholePart) {
        this.theWholePart = theWholePart;
    }

    //Вывод
    public String getResult() {
        setRationalFracNotCorrect();
        String s = nominator + "/" + denominator;
        System.out.println(s);
        getNormalize();
        return s;
    }

    //Суммирование
    public static RationalFrac summ(RationalFrac r1, RationalFrac r2) {
        r1.setRationalFracNotCorrect();
        r2.setRationalFracNotCorrect();
        if (r1.denominator!=r2.denominator) {
            return new RationalFrac(r1.nominator*r2.denominator+r2.nominator*r1.denominator, r1.denominator*r2.denominator);
        }
        return new RationalFrac(r1.nominator+r2.nominator, r1.denominator);
    }

    //Умножение
    public static RationalFrac multiple(RationalFrac r1, RationalFrac r2) {
        r1.setRationalFracNotCorrect();
        r2.setRationalFracNotCorrect();
        return new RationalFrac(r1.getNominator()*r2.getNominator(), r1.getDenominator()*r2.getDenominator());
    }

    public void getNormalize() {
        while (nominator > denominator) {
            nominator -= denominator;
            theWholePart++;
        }
        if (nominator == denominator) {
            theWholePart++;
            nominator = 1;
            denominator = 1;
        }
    }

    private void setRationalFracNotCorrect() {
        while (theWholePart > 0) {
            nominator += denominator;
            theWholePart--;
        }
    }

    public int getNominator() {
        return nominator;
    }

    public void setNominator(int nominator) {
        this.nominator = nominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getTheWholePart() {
        return theWholePart;
    }

    public void setTheWholePart(int theWholePart) {
        this.theWholePart = theWholePart;
    }

    public int compareTo(RationalFrac o) {
        if (this.theWholePart == o.theWholePart && this.nominator == o.nominator && this.denominator==o.denominator) {
            return 0;
        } else {
            return -1;
        }
    }
}
