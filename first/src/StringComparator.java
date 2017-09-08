import java.util.Comparator;

public class StringComparator implements Comparator<String> {

    private int i;

    public StringComparator(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public int compare(String o1, String o2) {
        if (o1.charAt(i) == o2.charAt(i))
            return 0;
        if (o1.charAt(i) > o2.charAt(i)) {
            return 1;
        } else {
            return -1;
        }
    }
}
