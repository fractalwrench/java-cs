package com.fractalwrench.algorithms.cci.ch1;


import java.util.Arrays;

/**
 * Cracking the Coding Interview Q1.2
 */
public class PermutationStringSolution {

    /**
     * Determines whether the two strings are permutations of each other
     *
     * @param a the first string
     * @param b the second string
     * @return true if the strings are permutations of each other, otherwise false
     * @throws IllegalArgumentException if either of the supplied strings are null
     */
    public boolean isInputPermutation(String a, String b) throws IllegalArgumentException {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Cannot compare permutations of null parameters");
        }
        if (a.equals(b) || a.length() != b.length()) { // not a permutation
            return false;
        }

        char[] firstChars = a.toCharArray();
        char[] secondChars = b.toCharArray();
        Arrays.sort(firstChars);
        Arrays.sort(secondChars);

        // compare sorted arrays (if a permutation, chars should be in same order for both arrays)

        for (int k = 0; k < firstChars.length; k++) {
            if (firstChars[k] != secondChars[k]) {
                return false;
            }
        }
        return true;
    }

}
