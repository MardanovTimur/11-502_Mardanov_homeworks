package ru.itis.inform;

public class Main {

    public static void main(String[] args) {
        int[][] a = {{0,7,9,0,0,14},
                     {7,0,10,15,0,0},
                    {9,10,0,11,0,2},
                {0,15,11,0,6,0},
                {0,0,0,6,0,9},
                {14,0,2,0,9,0}};
        Deix deix = new Deix(a);
        Massive b[];
        b = deix.getDeix(1);
        for (int i = 0; i <b.length; i++) {
            System.out.print(b[i].getValue()+" ");
        }
    }
}
