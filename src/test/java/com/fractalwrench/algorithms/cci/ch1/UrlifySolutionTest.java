package com.fractalwrench.algorithms.cci.ch1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class UrlifySolutionTest {

    private UrlifySolution solution;

    @Before
    public void setUp() throws Exception {
        solution = new UrlifySolution();
    }

    @Test
    public void getUrlifiedString() throws Exception {
        assertArrayEquals(new char[]{}, solution.getUrlifiedString(new char[]{}));
        assertArrayEquals("%20a".toCharArray(), solution.getUrlifiedString(" a  ".toCharArray()));
        assertArrayEquals("this%20is%20a%20test".toCharArray(), solution.getUrlifiedString("this is a test      ".toCharArray()));
    }

}