package ru.itis.inform.mergeSort_ThreadPool;

import sun.nio.ch.ThreadPool;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class MergeSort {
    static void printArray(int arr[]) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args[]) throws InterruptedException {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        ThreadMerge threadMerge = new ThreadMerge(arr, 0, arr.length - 1);
        threadMerge.start();
        threadMerge.join();
        System.out.println(threadMerge.isAlive());

        System.out.println("\nSorted array");
    }
}
