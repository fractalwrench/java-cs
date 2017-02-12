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

        // 1. check whether each element matches i.e. a[n] == b[n]
        // 2. if no match, increment a counter, and check for
        //      (A) Insertion/Deletion: a[n+1] == b[n] or a[n] == b[n + 1]
        //      (B) Replacement a[n+1] == b[n+1]
        //      (C) return false
        // 3. If counter >1, return false

        char[] firstAry = a.toCharArray();
        char[] secondAry = b.toCharArray();

        int diff = 0;

        int firstAryLen = firstAry.length;
        int secondAryLen = secondAry.length;

        for (int k = 0, m = 0; k < firstAryLen && m < secondAryLen; k++, m++) {
            if (diff > 1) {
                return false;
            }
            if (firstAry[k] != secondAry[m]) {
                diff++;

                // check for indel, and skip to next char if so
                if (m + 1 < secondAryLen && firstAry[k] == secondAry[m + 1]) {
                    m++;
                } else if (k + 1 < firstAryLen && firstAry[k + 1] == secondAry[m]) {
                    k++;
                }
            }
        }
        return diff == 1;
    }

}
