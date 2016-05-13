/**
 * Created by Тимур on 13.05.2016.
 */
public class SetsArrayWithLinksImpl implements Set {

    private int[] array;
    private static final int DEFAULT_SIZE = 50;

    public SetsArrayWithLinksImpl(int size) {
        this.array = new int[size];
        for (int i = 0; i<array.length; i++) {
            array[i] = i;
        }
    }

    public SetsArrayWithLinksImpl() {
        this.array = new int[DEFAULT_SIZE];
        for (int i = 0; i<array.length; i++) {
            array[i] = i;
        }
    }

    public void union(int setA, int setB) {
        int a = setA;
        int b = setB;
        while (a!=array[a]) {
            a = array[a];
        }
        while (b!=array[b]) {
            b = array[b];
        }
        if (a!=b) {
            System.out.println(setA+" "+setB);
            array[a] = b;
        }
    }

    public void find(int value) {
        int a = value;
        while (a!=array[a]) {
            a = array[a];
        }
        System.out.println(a);
    }
}
