package ru.itis.inform;

/**
 * Created by Timur Mardanov on 08.06.2017.
 * ITIS
 */
public class Quad {
    private double a=1;
    private double b;
    private double c;
    private double x1;
    private double x2;

    public Quad(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Quad(double b, double c) {
        this.b = b;
        this.c = c;
    }


    public String searchXY() {
        double desc = b*b-4*a*c;
        x1 = (-1*b + Math.sqrt(desc))/2*a;
        x2 = (-1*b - Math.sqrt(desc))/2*a;
        return "x1= "+x1+"; x2= "+x2+";";
    }



    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }
}
