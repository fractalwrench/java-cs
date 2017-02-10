package com.fractalwrench.structures;

import org.junit.Before;
import org.junit.Test;

import static com.fractalwrench.structures.ArrayList.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArrayListTest {

    private static final String DATA = "test";
    private static final String SECOND = "SECOND";
    private ArrayList<String> list;

    @Before
    public void setup() throws Exception {
        list = new ArrayList<>();
    }

    @Test
    public void delete() throws Exception {
        list.add(DATA);
        list.add(SECOND);
        list.add(DATA);

        assertEquals(DATA, list.delete(DATA));
        assertEquals(2, list.size());
        assertEquals(1, list.indexOf(DATA));

        assertEquals(DATA, list.delete(DATA));
        assertEquals(null, list.delete(DATA));
    }

    @Test
    public void clear() throws Exception {
        list.add(DATA);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertEquals(-1, list.indexOf(DATA));
    }

    @Test
    public void isEmptyAndSizeAndClear() throws Exception {
        assertTrue(list.isEmpty());

        list.add(DATA);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());

        list.add(null);
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
    }

    @Test
    public void indexOf() throws Exception {
        assertEquals(-1, list.indexOf(DATA));

        list.add(DATA);
        list.add(DATA);
        assertEquals(0, list.indexOf(DATA));

        list.add(SECOND);
        assertEquals(2, list.indexOf(SECOND));
    }

    @Test
    public void testCapacity() {
        assertEquals(DEFAULT_CAPACITY, list.getCapacity());

        for (int k = 0; k < DEFAULT_CAPACITY; k++) {
            list.add("");
        }
        assertEquals(DEFAULT_CAPACITY, list.getCapacity());

        list.add("");
        assertEquals(DEFAULT_CAPACITY * 2, list.getCapacity());

        for (int k = 1; k < DEFAULT_CAPACITY; k++) {
            list.add("");
        }
        assertEquals(DEFAULT_CAPACITY * 2, list.getCapacity());

        list.add("");
        assertEquals(DEFAULT_CAPACITY * 4, list.getCapacity());

    }

}