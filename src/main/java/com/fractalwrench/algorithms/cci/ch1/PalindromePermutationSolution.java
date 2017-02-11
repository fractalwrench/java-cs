package com.fractalwrench.algorithms.cci.ch1;

import java.util.HashMap;
import java.util.Map;

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
        if (isInvalidParam(input)) {
            return false;
        }

        char[] values = input.toCharArray();
        Map<Character, Character> map = new HashMap<>();

        // add each char to a hash table, then remove it if already present.
        // palindromes by definition have even numbers of each character
        // (with the exception of 1 char if an odd length).
        // therefore if the map size if > 1, it cannot be a permutation of a palindrome

        for (char value : values) {
            if (map.containsKey(value)) {
                map.remove(value);
            }
            else {
                map.put(value, value);
            }
        }
        return map.size() <= 1;
    }

    /**
     * Determines whether a given string is a palindrome
     * @param input the input
     * @return true if a palindrome, otherwise false
     */
    boolean isPalindrome(String input) {
        if (isInvalidParam(input)) {
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

    private boolean isInvalidParam(String input) {
        return input == null || input.length() <= 1;
    }
}
