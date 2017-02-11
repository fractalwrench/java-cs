package com.fractalwrench.algorithms.cci.ch1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromePermutationSolutionTest {

    private PalindromePermutationSolution solution;

    @Before
    public void setUp() throws Exception {
        solution = new PalindromePermutationSolution();
    }

    @Test
    public void isPermutationOfPalindrome() throws Exception {
        assertFalse(solution.isPermutationOfPalindrome(null));
        assertFalse(solution.isPermutationOfPalindrome(""));
        assertFalse(solution.isPermutationOfPalindrome("abc"));
        assertTrue(solution.isPermutationOfPalindrome("aa"));
        assertTrue(solution.isPermutationOfPalindrome("abcabc "));
        assertTrue(solution.isPermutationOfPalindrome("dog god"));
    }

    @Test
    public void isPalindrome() throws Exception {
        assertFalse(solution.isPalindrome(null));
        assertFalse(solution.isPalindrome(""));
        assertFalse(solution.isPalindrome("a"));
        assertFalse(solution.isPalindrome("abc"));
        assertTrue(solution.isPalindrome("aa"));
        assertTrue(solution.isPalindrome("abc cba"));
        assertTrue(solution.isPalindrome("abccba"));
        assertTrue(solution.isPalindrome("dog god"));
    }

}