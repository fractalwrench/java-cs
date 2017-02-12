package com.fractalwrench.algorithms.cci.ch1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RotateMatrixSolutionTest {

    private RotateMatrixSolution solution;

    @Before
    public void setUp() throws Exception {
        solution = new RotateMatrixSolution();
    }

    @Test
    public void emptyMatrixRotate() throws Exception {
        int[][] matrix = {};
        solution.rotateMatrix(matrix);
        assertArrayEquals(new int[][]{}, matrix);
    }

    @Test
    public void simpleMatrixRotate() throws Exception {
        int[][] input = {
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };
        int[][] expected = {
                new int[]{7, 4, 1},
                new int[]{8, 5, 2},
                new int[]{9, 6, 3}
        };

        solution.rotateMatrix(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void largerMatrixRotate() throws Exception {
        int[][] input = {
                new int[]{1, 2, 3, 4, 5},
                new int[]{6, 7, 8, 9, 10},
                new int[]{11, 12, 13, 14, 15},
                new int[]{16, 17, 18, 19, 20},
                new int[]{21, 22, 23, 24, 25}
        };
        int[][] expected = {
                new int[]{21, 16, 11, 6, 1},
                new int[]{22, 17, 12, 7, 2},
                new int[]{23, 18, 13, 8, 3},
                new int[]{24, 19, 14, 9, 4},
                new int[]{25, 20, 15, 10, 5}
        };

        solution.rotateMatrix(input);
        assertArrayEquals(expected, input);
    }


}