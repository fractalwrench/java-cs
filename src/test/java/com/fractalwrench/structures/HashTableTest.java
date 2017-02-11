package com.fractalwrench.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashTableTest {

    private static final String TEST_KEY = "key";
    private static final String TEST_VAL = "val";

    private HashTable<String, String> hashTable;

    @Before
    public void setUp() throws Exception {
        hashTable = new HashTable<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPut() throws Exception {
        hashTable.put(null, TEST_VAL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullGet() throws Exception {
        hashTable.get(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullRemove() throws Exception {
        hashTable.remove(null);
    }

    @Test
    public void putGetRemove() throws Exception {
        assertEquals(null, hashTable.get(TEST_KEY));
        assertEquals(null, hashTable.remove(TEST_KEY));

        hashTable.put(TEST_KEY, TEST_VAL);
        assertEquals(TEST_VAL, hashTable.get(TEST_KEY));
        assertEquals(TEST_VAL, hashTable.remove(TEST_KEY));
    }

    @Test
    public void clear() throws Exception {
        hashTable.put(TEST_KEY, TEST_VAL);
        assertEquals(TEST_VAL, hashTable.get(TEST_KEY));

        hashTable.clear();
        assertEquals(null, hashTable.get(TEST_KEY));
    }

}