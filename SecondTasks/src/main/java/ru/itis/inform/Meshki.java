package ru.itis.inform;

import java.util.Arrays;
import java.util.Scanner;

public class Meshki {

    private static int n, k;
    private static int[] a, b, c;
    private static int[] m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        a = new int[n-1];
        b = new int[n-1];
        c = new int[n-1];
        m = new int[n];

        for (int i = 0; i < n; i++) {
            m[i] = in.nextInt();
        }


        for (int i=1; i<n-1; i++) {
            p1(0,0, i);
        }
    }

    static void p1(int pos, int maxUsed, int k) {
        if (pos == k) {

        } else {
            for (int i = maxUsed + 1; i <= n; i++) {
                a[pos] = i;
                p1(pos + 1, i, k);
            }
        }
    }

}
