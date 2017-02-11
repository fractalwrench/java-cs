package com.fractalwrench.algorithms.cci.ch1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class UrlifySolutionTest {

    private UrlifySolution solution;

    @Before
    public void setUp() throws Exception {
        solution = new UrlifySolution();
    }

    @Test
    public void getUrlifiedString() throws Exception {
        assertArrayEquals(new char[]{}, solution.getUrlifiedString(new char[]{}));
        assertEquals("%20".toCharArray(), solution.getUrlifiedString(" ".toCharArray()));
        assertEquals("this is a  test".toCharArray(), solution.getUrlifiedString("this%20is%20a%20%20test".toCharArray()));
    }

}