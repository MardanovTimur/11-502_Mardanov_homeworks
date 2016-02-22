package ru.itis.inform;

import ru.itis.inform.Array.FareyArray;
import ru.itis.inform.Array.FareyArrayImpl;
import ru.itis.inform.Array.RationalNumber;

import java.util.Scanner;

import static org.junit.Assert.*;


public class FareyArrModuleTest {

    private FareyArrayImpl fareyArray;

    @org.junit.Before
    public void setUp() throws Exception{
        this.fareyArray = new FareyArrayImpl();
        this.fareyArray.generate(4);
    }

    @org.junit.Test
    public void TestArr() {
        RationalNumber[] actual = this.fareyArray.getArray();
        RationalNumber[] expected = new RationalNumber[100];
        for (int i = 2; i<100; i++) {
            expected[i] = new RationalNumber();
        }
        expected[0] = new RationalNumber(0,1);
        expected[1] = new RationalNumber(1,4);
        expected[2] = new RationalNumber(1,3);
        expected[3] = new RationalNumber(1,2);
        expected[4] = new RationalNumber(2,3);
        expected[5] = new RationalNumber(3,4);
        expected[6] = new RationalNumber(1,1);

        assertEquals(equalsArray(actual,expected),true);
    }

    private boolean equalsArray(RationalNumber[] a, RationalNumber[] b) {
        boolean f = true;
        for (int i = 0; i<100; i++) {
            if (!(a[i].getB()==b[i].getB() && a[i].getA()==b[i].getA())) {
                return false;
            }
        }
        return f;
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void TestOnNegative() throws Exception {
        new RationalNumber(0,0);
    }

}
