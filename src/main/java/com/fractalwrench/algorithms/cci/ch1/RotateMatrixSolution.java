package com.fractalwrench.algorithms.cci.ch1;

/**
 * Cracking the Coding Interview Q1.7
 */
public class RotateMatrixSolution {

    /**
     * Rotates a matrix of integers by 90 degrees, in place.
     *
     * @param matrix the matrix
     */
    public void rotateMatrix(int[][] matrix) {

        int len = matrix.length;
        for (int layer = 0; layer < len / 2; layer++) {

            int first = layer;
            int end = len - 1 - layer;

            for (int a = first; a< end; a++) {
                int offset = a - first;
                int offsetEnd = end - offset;

                // swap the edge of each layer
                int top = matrix[first][a];
                matrix[first][a] = matrix[offsetEnd][first];
                matrix[offsetEnd][first] = matrix[end][end - offset];
                matrix[end][end - offset] = matrix[a][end];
                matrix[a][end] = top;
            }
        }


        // 2nd iter wants   m[0][1] -> m[1][2],
        //                  m[1][2] -> m[2][1]
        //                  m[2][1] -> m[1][0]
        //                  m[1][0] -> m[0][1]

//     {1, 2, 3},
//     {4, 5, 6},
//     {7, 8, 9}
//
//     {7, 4, 1},
//     {8, 5, 2},
//     {9, 6, 3}

        // matrix[0][0] -> matrix[0][n]
        // matrix[0][n] -> matrix[n][n]
        // matrix[n][n] -> matrix[n][0]
        // matrix[0][n] -> matrix[0][0]

    }

}
