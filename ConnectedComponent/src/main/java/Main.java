public class Main {
    public static void main(String[] args) {
        Set setsArray = new SetsArrayImpl(10);
        setsArray.union(1,2);
        setsArray.union(2,5);
        setsArray.union(4,3);
        setsArray.union(5,4);
        setsArray.find(5);

        Set set = new SetsArrayWithLinksImpl(10);
        set.union(2,4);
        set.union(3,6);
        set.union(2,3);
        set.find(2);
    }
}
