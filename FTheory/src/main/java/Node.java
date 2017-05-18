/**
 * Created by alisa on 17.04.2017.
 */
public class Node {

    private Character key;

    private boolean isNegative;

    private boolean isBound = true;

    public Node() {
    }

    public Node(char key, boolean isNegative) {
        this.key = key;
        this.isNegative = isNegative;
    }

    public Character getKey() {
        return key;
    }

    public void setKey(Character key) {
        this.key = key;
    }

    public boolean isNegative() {
        return isNegative;
    }

    public void setNegative(boolean negative) {
        isNegative = negative;
    }

    public boolean isBound() {
        return isBound;
    }

    public void setBound(boolean bound) {
        isBound = bound;
    }
}
