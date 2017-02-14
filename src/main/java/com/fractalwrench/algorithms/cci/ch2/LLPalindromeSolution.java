package com.fractalwrench.algorithms.cci.ch2;

import java.util.LinkedList;
import java.util.Stack;

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

        Stack<String> stack = new Stack<>();

        for (String s : linkedList) { // add each item to a stack
            stack.push(s);
        }
        for (String s : linkedList) { // pop the stack (reads the ll in reverse)
            if (!stack.pop().equals(s)) {
                return false;
            }
        }
        return true;
    }

}
