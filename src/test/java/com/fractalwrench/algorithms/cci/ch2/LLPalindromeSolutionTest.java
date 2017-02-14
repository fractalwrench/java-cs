package com.fractalwrench.algorithms.cci.ch2;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LLPalindromeSolutionTest {

    private static final String VAL_TEST = "test";
    private static final String VAL_ANOTHER = "another element";

    private LLPalindromeSolution solution;
    private LinkedList<String> linkedList;

    @Before
    public void setUp() throws Exception {
        solution = new LLPalindromeSolution();
        linkedList = new LinkedList<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullCase() throws Exception {
        solution.isPalindrome(null);
    }

    @Test
    public void minPalSize() throws Exception {
        assertFalse(solution.isPalindrome(linkedList));

        linkedList.add(VAL_TEST);
        assertFalse(solution.isPalindrome(linkedList));

        linkedList.add(VAL_ANOTHER);
        assertFalse(solution.isPalindrome(linkedList));

        linkedList.removeLast();
        linkedList.add(VAL_TEST);
        assertTrue(solution.isPalindrome(linkedList));
    }

    @Test
    public void isPalindrome() throws Exception {
        linkedList.add(VAL_TEST);
        linkedList.add(VAL_ANOTHER);
        linkedList.add(VAL_TEST);
        assertTrue(solution.isPalindrome(linkedList));

        linkedList.removeLast();
        linkedList.add(VAL_ANOTHER);
        linkedList.add(VAL_TEST);
        assertTrue(solution.isPalindrome(linkedList));

        linkedList.removeLast();
        assertFalse(solution.isPalindrome(linkedList));
    }

}