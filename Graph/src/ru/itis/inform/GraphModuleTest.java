package ru.itis.inform;

/**
 * Created by Тимур on 20.02.2016.
 */

import java.util.Arrays;

import static org.junit.Assert.*;

public class GraphModuleTest {
    private GraphMatrixImpl graph[] = new GraphMatrixImpl[2];
    private boolean actual;
    private boolean expected;

    @org.junit.Before
    public void setUp() throws Exception {
        for (int i = 0; i < 2; i++) {
            this.graph[i] = new GraphMatrixImpl();
        }
    }

    @org.junit.Test
    public void test1() throws Exception {
        this.actual = false;
        this.expected = true;
        int[][] actualM = new int[52][52];
        int[][] expectedM;

        graph[0].addVertex();
        graph[0].addVertex();
        graph[0].addVertex();
        graph[0].addEdgeDirection(1, 2, 3);
        graph[0].addEdgeDirection(1, 3, 9);
        graph[0].addEdgeDirection(2, 3, 5);
        actualM = graph[0].runFloyd();

        expectedM = new int[][]{{0, 3, 8}, {0, 0, 5}, {0, 0, 0}};

        actual = equalsMatrix(actualM, expectedM);

        assertEquals("Error-1", actual, expected);

    }

    @org.junit.Test
    public void test2() throws Exception {
        this.actual = false;
        this.expected = true;
        int[][] actualM = new int[52][52];
        int[][] expectedM;
        graph[1].addVertex();
        graph[1].addVertex();
        graph[1].addVertex();
        graph[1].addEdgeNonDirection(1, 3, 300);
        graph[1].addEdgeNonDirection(2, 3, 3);
        graph[1].addEdgeNonDirection(2, 1, 5);

        actualM = graph[1].runFloyd();

        expectedM = new int[][]{
                {0, 5, 8},
                {5, 0, 3},
                {8, 3, 0}
        };

        actual = equalsMatrix(actualM, expectedM);

        assertEquals("Error-2", actual, expected);
    }

    private boolean equalsMatrix(int[][] a, int[][] b) {
        if (Arrays.deepEquals(a, b)) {
            return true;
        } else {
            return false;
        }
    }

}
