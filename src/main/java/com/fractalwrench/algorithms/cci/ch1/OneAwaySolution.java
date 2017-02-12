package com.fractalwrench.algorithms.cci.ch1;

/**
 * Cracking the Coding Interview Q1.5
 */
public class OneAwaySolution {

    /**
     * Determines whether the given strings differ by only one character
     * (insertion, deletion, or replacement
     *
     * @param a the first string
     * @param b the second string
     * @return true if they only differ by one character, otherwise false
     * @throws IllegalArgumentException if either strings are null
     */
    public boolean isOneEditAway(String a, String b) throws IllegalArgumentException {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Cannot check difference on a null object reference");
        }
        int diff = a.length() - b.length();

        if (a.equals(b) || (diff != -1 && diff != 1)) { // only one char can have changed...
            return false;
        }

        return false;
    }

}
