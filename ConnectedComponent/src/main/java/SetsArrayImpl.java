public class SetsArrayImpl implements Set {
    private Array[] array;
    private static final int DEFAULT_SIZE = 50;

    public SetsArrayImpl(int size) {
        this.array = new Array[size + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Array();
        }
    }

    public SetsArrayImpl() {
        this.array = new Array[DEFAULT_SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Array();
        }
    }

    public void union(int setA, int setB) {
        if (!array[setA].isCheck() && !array[setB].isCheck()) {
            array[setA].setValue(setA);
            array[setB].setValue(setA);
            connect(setA, setB);

        } else {
            if (!array[setA].isCheck() && array[setB].isCheck()) {
                array[setA].setValue(array[setB].getValue());
                connect(setA, setB);
            }
            if (!array[setB].isCheck() && array[setA].isCheck()) {
                array[setB].setValue(array[setA].getValue());
                connect(setA, setB);
            }
            if (array[setA].isCheck() && array[setB].isCheck()) {
                connect(setA, setB);
                for (int i = 0; i < array.length; i++) {
                    if (array[setB].getValue() == array[i].getValue()) {
                        array[i].setValue(array[setA].getValue());
                    }
                }
            }
        }
    }

/*    public int getSet(int numberOfSet) {

    }*/

    public void getPath(int setA, int setB) {
        Array[] way = getWay(setA, setB);
        for (int i = 0; i <= way.length; i++) {
            if (way[i].getValue() != -1)
                System.out.print(way[i]);
        }
    }

    private Array[] getWay(int setA, int setB) {
        Array[] way = new Array[array.length];
        int i = 0;
        way[0] = array[setA];
        while (way[i] != array[setB]) {
            way[i + 1] = way[i].getNext();
            way[i].setNext(way[i + 1]);
            i++;
        }
        return way;
    }

    public int find(int value) {
        return array[value].getValue();
        /* int[] arr = new int[array.length];
        int a = array[value].getValue();
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (a == array[i].getValue()) {
                arr[j] = i;
                j++;
            }
        }
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != 0)
                System.out.print(arr[i] + " ");*/
    }

    private void connect(int setA, int setB) {
        array[setA].setNext(array[setB]);
        array[setB].setNext(array[setA]);
    }
}
