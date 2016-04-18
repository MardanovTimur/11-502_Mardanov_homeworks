/**
 * Created by Тимур on 01.04.2016.
 */
import ru.itis.inform.Element;
import ru.itis.inform.MatrixCode;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class Test {

    private MatrixCode matrixCode;


    @org.junit.Before
    public void setUp() {

    }

    @org.junit.Test
    public void Test() {
        int[][] matrix = {{1,2,3},{1,3,2},{4,4,5}};
        matrixCode = new MatrixCode(matrix);
        matrixCode.show();

        int[][] matrix1 = new int[3][3];
        matrix1 = matrixCode.decode();

        System.out.println();
        matrixCode.insert(1,1,5);
        matrixCode.show();

        System.out.println();
        matrixCode.delete(2,2);
        matrixCode.show();

        System.out.println();
        ArrayList<Element> arrayList = matrixCode.minList();
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i).getValue()+", ");
        }

        System.out.println();
        System.out.println("--"+matrixCode.sumDiag()+"--");

        matrixCode.transp();
        matrixCode.show();

        System.out.println();
        matrixCode.sumCols(0,1);
        matrixCode.show();
    }
}
