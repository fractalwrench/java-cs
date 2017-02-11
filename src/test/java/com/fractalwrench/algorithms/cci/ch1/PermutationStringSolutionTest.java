package com.fractalwrench.algorithms.cci.ch1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PermutationStringSolutionTest {

    private static final Tuple[] PERMUTATIONS = {
            new Tuple("abc", "cba"),
            new Tuple("abc", "bac"),
            new Tuple("marmalade jam", "jam marmalade"),
    };

    private static final Tuple[] NOT_PERMUTATIONS = {
            new Tuple("", ""),
            new Tuple(" ", " "),
            new Tuple("a", "a"),
            new Tuple("abc", "abc"),
            new Tuple("abcd", "dbaa"),
            new Tuple("marmalade jam", "jam of marmalade"),
    };

    private PermutationStringSolution solution;

    @Before
    public void setUp() throws Exception {
        solution = new PermutationStringSolution();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullA() throws Exception {
        solution.isInputPermutation(null, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullB() throws Exception {
        solution.isInputPermutation("", null);
    }

    @Test
    public void isInputPermutation() throws Exception {
        for (Tuple permutation : PERMUTATIONS) {
            assertTrue(solution.isInputPermutation(permutation.a, permutation.b));
        }
    }

    @Test
    public void isNotInputPermutation() throws Exception {
        for (Tuple permutation : NOT_PERMUTATIONS) {
            assertFalse(solution.isInputPermutation(permutation.a, permutation.b));
        }
    }

    private static class Tuple {
        private final String a;
        private final String b;

        private Tuple(String a, String b) {
            this.a = a;
            this.b = b;
        }
    }

}