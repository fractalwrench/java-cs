package com.fractalwrench.algorithms.cci.ch1;

/**
 * Cracking the Coding Interview Q1.3
 */
public class UrlifySolution {

    public static final int REQUIRED_CHARS = 2;

    /**
     * Replaces all the spaces in the string with %20.
     * <p>
     * This operation is done in place using a char array, as per the parameters of the problem.
     * It is assumed that there are exactly enough elements at the end of the char array to allow for
     * the edition of %20.
     *
     * @param input the input
     * @return the URLified string
     */
    public char[] getUrlifiedString(char[] input) {
        int spaceCount = getSpaceCount(input);

        // 1. iterate backwards from the end of the array, and shift non-space chars to the end.
        // 2. each time a space is found, add '%' '2' '0' and decrement the number of spaces left.

        for (int k = input.length - 1; k >= 0; k--) {
            char c = input[k - (spaceCount * REQUIRED_CHARS)]; // get first character which isn't the tail

            if (c != ' ') { // shift to end of array
                input[k] = c;
            } else {
                input[k - 2] = '%';
                input[k - 1] = '2';
                input[k] = '0';
                spaceCount--;
                k -= REQUIRED_CHARS;
            }
        }
        return input;
    }

    /**
     * Count the number of spaces which aren't part of the String's 'tail'
     * @param input the input
     * @return the count of spaces
     */
    private int getSpaceCount(char[] input) {
        int total = 0;
        int count = 0;

        for (char c : input) {
            if (c == ' ') {
                count++;
            }
            else if (c != ' ') {
                total += count;
                count = 0;
            }
        }
        return total;
    }

}
