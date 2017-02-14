package com.fractalwrench.algorithms.cci.ch2;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Cracking the Coding Interview Q2.6
 */
public class LLPalindromeSolution {

    private static final int MIN_PALINDROME_SIZE = 2;

    public boolean isPalindrome(LinkedList<String> linkedList) {
        if (linkedList == null) {
            throw new IllegalArgumentException("Cannot check if null LinkedList is palindrome");
        }
        if (linkedList.size() < MIN_PALINDROME_SIZE) {
            return false;
        }

        return false;
    }

}
