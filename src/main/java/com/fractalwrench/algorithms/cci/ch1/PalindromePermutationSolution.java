package com.fractalwrench.algorithms.cci.ch1;

/**
 * Cracking the Coding Interview Q1.4
 */
public class PalindromePermutationSolution {

    /**
     * Determines whether a given string is a permutation of a palindrome.
     *
     * @return true if a permutation, otherwise false
     */
    public boolean isPermutationOfPalindrome(String input) {
        return false;
    }

    /**
     * Determines whether a given string is a palindrome
     * @param input the input
     * @return true if a palindrome, otherwise false
     */
    boolean isPalindrome(String input) {
        if (input == null || input.length() <= 1) {
            return false;
        }

        char[] values = input.toCharArray();

        for (int a = 0, b = values.length - 1; a < b; a++, b--) {
            if (values[a] != values[b]) {
                return false;
            }
        }
        return true;
    }
}
