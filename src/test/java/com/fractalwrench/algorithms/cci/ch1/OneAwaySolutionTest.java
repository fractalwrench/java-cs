package com.fractalwrench.algorithms.cci.ch1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OneAwaySolutionTest {

    private static final String EMPTY_STRING = "";

    private OneAwaySolution solution;

    @Before
    public void setUp() throws Exception {
        solution = new OneAwaySolution();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullA() throws Exception {
        solution.isOneEditAway(null, EMPTY_STRING);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullB() throws Exception {
        solution.isOneEditAway(EMPTY_STRING, null);
    }

    @Test
    public void sameString() throws Exception {
        assertFalse(solution.isOneEditAway(EMPTY_STRING, EMPTY_STRING));
        String data = "a test";
        assertFalse(solution.isOneEditAway(data, data));
    }

    @Test
    public void insertion() throws Exception {
        assertTrue(solution.isOneEditAway("test", "tesst"));
        assertTrue(solution.isOneEditAway("Addition", "Aaddition"));
        assertFalse(solution.isOneEditAway("123", "12345"));
        assertFalse(solution.isOneEditAway("drawable-xxxhdpi", "drawable-xxxxxxxxxxxxhdpi"));
    }

    @Test
    public void deletion() throws Exception {
        assertTrue(solution.isOneEditAway("test", "tst"));
        assertTrue(solution.isOneEditAway("Dude where's my char", "Dude wheres my char"));
        assertFalse(solution.isOneEditAway("Parrot", ""));
        assertFalse(solution.isOneEditAway("Parrot", "Paot"));
    }

    @Test
    public void replacement() throws Exception {
        assertTrue(solution.isOneEditAway("hot", "h0t"));
        assertTrue(solution.isOneEditAway("Change It", "Change_It"));
        assertFalse(solution.isOneEditAway("dog", "bird"));
        assertFalse(solution.isOneEditAway("woot", "w33t"));
    }

}