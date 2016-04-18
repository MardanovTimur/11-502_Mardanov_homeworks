package ru.itis.inform;

/**
 * Created by Тимур on 05.04.2016.
 */
public class BucketSort {
    private static int iterations = 0;

    public static int[] sort(int[] a) {
        iterations = 0;
        int maxValue;

        if (a == null) {
            throw new IllegalArgumentException();
        } else
            maxValue = a[0];

        for (int i = 0; i < a.length; i++) {
            if (maxValue < a[i]) {
                maxValue = a[i];
            }
            iterations++;
        }

        int bucket[] = new int[maxValue + 1];

        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
            iterations++;
        }

        int[] stack = new int[a.length];

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                stack[index++] = i;
                iterations++;
            }
        }

        return stack;
    }

    public static int getIterations(){
        return iterations;
    }
}
