package com.fractalwrench.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringBuilderTest {

    private static final String STR_31_CHAR = "abcdefghijklmnopqrstuvwxyz12345";
    private static final String STR_32_CHAR = "abcdefghijklmnopqrstuvwxyz123456";
    private static final String STR_33_CHAR = "abcdefghijklmnopqrstuvwxyz1234567";

    private StringBuilder stringBuilder;

    @Before
    public void setup() {
        stringBuilder = new StringBuilder();
    }

    @Test
    public void append() throws Exception {
        assertEquals("", stringBuilder.toString());

        stringBuilder.append(STR_31_CHAR);
        stringBuilder.append(STR_32_CHAR);
        stringBuilder.append(" ");
        stringBuilder.append(STR_33_CHAR);

        String expected = STR_31_CHAR + STR_32_CHAR + " " + STR_33_CHAR;
        assertEquals(expected, stringBuilder.toString());
    }

    @Test
    public void getSize() throws Exception {
        assertEquals(0, stringBuilder.getSize());
        stringBuilder.append(STR_31_CHAR);
        assertEquals(31, stringBuilder.getSize());

        stringBuilder.append("");
        assertEquals(31, stringBuilder.getSize());
        String data = "test";
        stringBuilder.append(data);
        assertEquals(35, stringBuilder.getSize());

        stringBuilder.clear();
        stringBuilder.append(data);
        assertEquals(data.length(), stringBuilder.getSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullArg() throws Exception {
        stringBuilder.append(null);
    }

    @Test
    public void getCapacity() throws Exception {
        assertEquals(StringBuilder.DEFAULT_CAPACITY, stringBuilder.getCapacity());

        stringBuilder.append(STR_31_CHAR);
        assertEquals(StringBuilder.DEFAULT_CAPACITY, stringBuilder.getCapacity());

        stringBuilder.clear();
        stringBuilder.append(STR_32_CHAR);
        assertEquals(StringBuilder.DEFAULT_CAPACITY, stringBuilder.getCapacity());

        // empty arg shouldn't increase capacity
        stringBuilder.append("");
        assertEquals(StringBuilder.DEFAULT_CAPACITY, stringBuilder.getCapacity());

        stringBuilder.clear();
        stringBuilder.append(STR_33_CHAR);
        assertEquals(StringBuilder.DEFAULT_CAPACITY * 2, stringBuilder.getCapacity());

        stringBuilder.append(STR_33_CHAR);
        assertEquals(StringBuilder.DEFAULT_CAPACITY * 4, stringBuilder.getCapacity());
    }

}