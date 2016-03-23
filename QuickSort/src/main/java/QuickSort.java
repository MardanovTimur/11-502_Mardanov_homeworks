import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

/**
 * Created by Тимур on 21.03.2016.
 */
public class QuickSort {
    private Point[] point;
    private Point[] lastPoints;
    private int sizePoint;
    private int startIndexPoint;
    private LinkedList<Point> upPoints;
    private int indexPoint;
    private LinkedList<Point> downPoints;

    public Point[] getLastPoints() {
        return lastPoints;
    }

    public QuickSort(Point[] point) {
        this.sizePoint = point.length;
        this.point = new Point[sizePoint];
        this.lastPoints = new Point[sizePoint + 10];
        this.point = point;
    }

    private void searchFirstPoints() {

        double xPosition = this.point[0].getX();
        this.startIndexPoint = 0;

        for (int i = 1; i < sizePoint; i++) {
            if (this.point[i].getX() < xPosition) {
                xPosition = this.point[i].getX();
                this.startIndexPoint = i;
            }
        }
        this.lastPoints[indexPoint] = point[startIndexPoint];
        point[startIndexPoint].setFlag();

        this.indexPoint++;

        xPosition = this.point[0].getX();

        for (int i = 1; i < sizePoint; i++) {
            if (this.point[i].getX() > xPosition) {
                xPosition = this.point[i].getX();
                this.startIndexPoint = i;
            }
        }

        this.lastPoints[indexPoint] = point[startIndexPoint];
        point[startIndexPoint].setFlag();
        this.indexPoint++;
    }

    private Point searchThirdPoint(Point a, Point b, boolean f) {

        double vectorThisLineX = a.getX() - b.getX();
        double vectorThisLineY = a.getY() - b.getY();

        double A = vectorThisLineY;
        double B = -vectorThisLineX;
        double C = -B * a.getY() - A * a.getX();
        double d = 0;
        int i = 0;

        while ((point[i].getFlag() || (point[i].getX() * A + C + point[i].getY() * B < 0 )) && i < point.length - 1) {
            i++;
        }
        double max = 0;
        if (i != point.length - 1) {
            max = Math.abs(A * point[i].getX() + B * point[i].getY() + C) / Math.sqrt(A * A + B * B);
            startIndexPoint = i;
        }
        for (int j = i + 1; j < sizePoint; j++) {
            if (!point[j].getFlag() && (point[j].getX() * A + C > -point[j].getY() * B)) {
                d = Math.abs(A * point[j].getX() + B * point[j].getY() + C) / Math.sqrt(A * A + B * B);
                if (d >= max) {
                    max = d;
                    startIndexPoint = j;
                }
            }
        }

        if (max <= 0) {
            return null;
        } else {
            this.lastPoints[indexPoint] = point[startIndexPoint];
            this.indexPoint++;
            point[startIndexPoint].setFlag();
            return lastPoints[indexPoint - 1];
        }
    }

    private Point searchThirdPoint1(Point a, Point b, boolean f) {

        double vectorThisLineX = a.getX() - b.getX();
        double vectorThisLineY = a.getY() - b.getY();

        double A = vectorThisLineY;
        double B = -vectorThisLineX;
        double C = -B * a.getY() - A * a.getX();
        double d = 0;
        int i = 0;

        while ((point[i].getFlag() || (point[i].getX() * A + C + point[i].getY() * B > 0 )) && i < point.length - 1) {
            i++;
        }
        double max = 0;
        if (i != point.length - 1) {
            max = Math.abs(A * point[i].getX() + B * point[i].getY() + C) / Math.sqrt(A * A + B * B);
            startIndexPoint = i;
        }
        for (int j = i + 1; j < sizePoint; j++) {
            if (!point[j].getFlag() && (point[j].getX() * A + C < -point[j].getY() * B)) {
                d = Math.abs(A * point[j].getX() + B * point[j].getY() + C) / Math.sqrt(A * A + B * B);
                if (d >= max) {
                    max = d;
                    startIndexPoint = j;
                }
            }
        }

        if (max <= 0) {
            return null;
        } else {
            this.lastPoints[indexPoint] = point[startIndexPoint];
            this.indexPoint++;
            point[startIndexPoint].setFlag();
            return lastPoints[indexPoint - 1];
        }
    }

    public Point[] searchPoints() {
        searchFirstPoints();
        buildInsideCoverUP(lastPoints[0], lastPoints[1]);
        buildOnsideCoverUp(lastPoints[0], lastPoints[1]);
        return lastPoints;
    }

    private int buildInsideCoverUP(Point a, Point b) {
        if (b == null || a == null) {
            return 0;
        }
        Point backUp = searchThirdPoint(a, b, true);


        buildInsideCoverUP(a, backUp);
        buildInsideCoverUP(backUp, b);
        return 0;
    }

    private  int buildOnsideCoverUp(Point a, Point b) {
        if (b == null || a == null) {
            return 0;
        }

        Point backDown = searchThirdPoint1(a, b, false);

        buildOnsideCoverUp(a, backDown);
        buildOnsideCoverUp(backDown, b);
        return 0;
    }

}