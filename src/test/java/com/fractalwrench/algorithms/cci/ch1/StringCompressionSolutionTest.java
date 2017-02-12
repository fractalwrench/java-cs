package com.fractalwrench.algorithms.cci.ch1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCompressionSolutionTest {

    private StringCompressionSolution solution;

    @Before
    public void setUp() throws Exception {
        solution = new StringCompressionSolution();
    }

    @Test(expected = IllegalArgumentException.class)
    public void compressNullString() throws Exception {
        solution.compressString(null);
    }

    @Test
    public void compressString() throws Exception {
        assertEquals("", solution.compressString(""));

        String noChange = "abcdef123";
        assertEquals(noChange, solution.compressString(noChange));

        String noImprovement = "aabbccdd";
        assertEquals(noImprovement, solution.compressString(noImprovement));

        assertEquals("a5B1b2c1", solution.compressString("aaaaaBbbc"));
    }

}