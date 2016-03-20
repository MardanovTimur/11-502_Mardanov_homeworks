import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Тимур on 18.03.2016.
 */

public class Cover {

    private LinkedList<Point> lastPoints = new LinkedList<Point>();
    private LinkedList<Point> points = new LinkedList<Point>();
    private int startIndexPoint = 0;
    private int n;

    public Cover(LinkedList<Point> points) {
        this.points = points;
        this.n = points.size();
    }

    public LinkedList<Point> search() {
        chooseFirstPoint();
        getSecondPoint();

        getIndexesTheNextPoints(startIndexPoint);

        return this.lastPoints;
    }

    private void chooseFirstPoint() {
        double yDownPosition = this.points.get(0).getY();
        double xLeftPosition = this.points.get(0).getX();

        int n = this.points.size();

        for (int i = 1; i < n; i++) {
            if (this.points.get(i).getY() < yDownPosition) {
                yDownPosition = this.points.get(i).getY();
                xLeftPosition = this.points.get(i).getX();
                this.startIndexPoint = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (this.points.get(i).getY() == yDownPosition && xLeftPosition > this.points.get(i).getX() && startIndexPoint != i) {
                yDownPosition = this.points.get(i).getY();
                xLeftPosition = this.points.get(i).getX();
                this.startIndexPoint = i;
            }
        }

        this.lastPoints.addLast(points.get(startIndexPoint));

    }

    private void getSecondPoint() {
        int index = 0;
        double vectX = 1;
        double vectY = 0;
        double lengthFirstVector = 1;
        double cosUngle = -1;
        for (int j = 0; j < n; j++) {
            double vectXs = points.get(j).getX() - lastPoints.get(0).getX();
            double vectYs = points.get(j).getY() - lastPoints.get(0).getY();
            double lengthSecondVector = Math.sqrt(vectXs * vectXs + vectYs * vectYs);
            double dick = (vectX * vectXs + vectY * vectYs) / (lengthFirstVector * lengthSecondVector);
            if (cosUngle < dick) {
                index = j;
                cosUngle = dick;
            }
        }
        this.points.get(index).setFlag();
        this.lastPoints.addLast(points.get(index));
    }


    private void getIndexesTheNextPoints(int startIndexPosition) {
        int i = 1;
        int index = 0;
        while (!points.get(startIndexPosition).getFlag()) {
            double vectX = lastPoints.get(i - 1).getX() - lastPoints.get(i).getX();
            double vectY = lastPoints.get(i - 1).getY() - lastPoints.get(i).getY();
            double lengthFirstVector = Math.sqrt(vectX * vectX + vectY * vectY);
            double cosUngle = 1;
            for (int j = 0; j < n; j++) {
                if (!points.get(j).getFlag()) {
                    double vectXs = points.get(j).getX() - lastPoints.get(i).getX();
                    double vectYs = points.get(j).getY() - lastPoints.get(i).getY();
                    double lengthSecondVector = Math.sqrt(vectXs * vectXs + vectYs * vectYs);
                    double dick = (vectX * vectXs + vectY * vectYs) / (lengthFirstVector * lengthSecondVector);
                    if (cosUngle > dick) {
                        index = j;
                        cosUngle = dick;
                    }
                }
            }
            i++;
            this.points.get(index).setFlag();
            this.lastPoints.addLast(points.get(index));
            index = 0;
        }
    }


}
