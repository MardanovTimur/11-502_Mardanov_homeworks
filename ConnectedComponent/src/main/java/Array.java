
public class Array {

    private int value = -1;
    private boolean isCheck = false;
    private Array next;

    public void setValue(int value) {
        this.value = value;
        setCheck();
    }

    public Array getNext() {
        return next;
    }

    public void setNext(Array next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck() {
        isCheck = true;
    }
}
