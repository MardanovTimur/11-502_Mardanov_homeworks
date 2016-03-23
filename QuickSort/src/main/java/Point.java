/**
 * Created by Тимур on 18.03.2016.
 */
public class Point {
    private double x, y;
    private boolean flag = false;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setFlag() {
        this.flag = true;
    }

    public boolean getFlag() {
        return flag;
    }
    @Override
    public String toString() {
        String s = "("+getX()+", "+getY()+");";
        return s;
    }


}
