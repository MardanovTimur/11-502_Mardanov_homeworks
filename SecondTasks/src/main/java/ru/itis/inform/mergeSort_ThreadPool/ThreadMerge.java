package ru.itis.inform.mergeSort_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMerge extends Thread {

    static int[] array;
    int left;
    int rigth;

    int[] merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        return arr;
    }

    int[] sort(final int arr[], final int l, final int r) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        if (l < r) {
            final int m = (l + r) / 2;
            executorService.execute(new Runnable() {
                public void run() {
                    sort(arr, l, m);
                }
            });

            executorService.execute(new Runnable() {
                public void run() {
                    sort(arr, m + 1, r);
                }
            });


            return merge(arr, l, m, r);
        }
        MergeSort.printArray(array);
        return null;
    }

    public ThreadMerge(int arr[], int l, int r) {
        this.array = arr;
        this.left = l;
        this.rigth = r;
    }

    @Override
    public void run() {
        sort(array, left, rigth);
    }
}
