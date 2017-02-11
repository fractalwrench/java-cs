package com.fractalwrench.algorithms.cci.ch1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UniqueStringSolutionTest {

    private static final String[] UNIQUE_VALS = {"abc", "aAbBcC", "12409 FAOIJ", "\n\t\r"};
    private static final String[] NON_UNIQUE_VALS = {"aa", "abca", "AbaA", "\n\r\t\n", "  "};

    private UniqueStringSolution uniqueStringSolution;

    @Before
    public void setUp() throws Exception {
        uniqueStringSolution = new UniqueStringSolution();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNull() throws Exception {
        uniqueStringSolution.hasAllUniqueChars(null);
    }

    @Test
    public void testEmpty() throws Exception {
        assertTrue(uniqueStringSolution.hasAllUniqueChars(""));
    }

    @Test
    public void allUnique() throws Exception {
        for (String val : UNIQUE_VALS) {
            assertTrue(uniqueStringSolution.hasAllUniqueChars(val));
        }
    }

    @Test
    public void notUnique() throws Exception {
        for (String val : NON_UNIQUE_VALS) {
            assertFalse(uniqueStringSolution.hasAllUniqueChars(val));
        }
    }

}