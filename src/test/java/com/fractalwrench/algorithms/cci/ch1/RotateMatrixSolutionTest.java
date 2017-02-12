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

}