package com.fractalwrench.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    private static final String TEST = "test";
    private static final String SECOND = "second";
    private static final int[] ILLEGAL_INDICES = new int[]{-3, 0, 57};

    private SinglyLinkedList<String> linkedList;

    @Before
    public void setup() throws Exception {
        linkedList = new SinglyLinkedList<>();
    }

    @Test
    public void size() throws Exception {
        int limit = 10;
        assertEquals(0, linkedList.size());

        for (int k = 0; k < limit; k++) {
            linkedList.insertFirst(TEST);
            assertEquals(k, linkedList.size());
        }
        for (int k = limit; k > 0; k--) {
            linkedList.deleteLast();
            assertEquals(k, linkedList.size());
        }
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(linkedList.isEmpty());
        linkedList.insertFirst(TEST);
        assertFalse(linkedList.isEmpty());
    }

    @Test
    public void indexOf() throws Exception {
        assertEquals(-1, linkedList.indexOf(TEST));

        linkedList.insertFirst(TEST);
        assertEquals(0, linkedList.indexOf(TEST));

        linkedList.insertLast(TEST);
        assertEquals(0, linkedList.indexOf(TEST));

        linkedList.insertLast(SECOND);
        assertEquals(2, linkedList.indexOf(SECOND));

        linkedList.insertLast(SECOND);
        linkedList.deleteFromIndex(1);
        assertEquals(1, linkedList.indexOf(SECOND));
    }

    @Test
    public void insertDeleteFirst() throws Exception {
        linkedList.insertFirst("c");
        linkedList.insertFirst("b");
        linkedList.insertFirst("a");
        assertEquals("a", linkedList.deleteFirst());
        assertEquals("b", linkedList.deleteFirst());
        assertEquals("c", linkedList.deleteFirst());
    }

    @Test
    public void insertDeleteLast() throws Exception {
        linkedList.insertLast("a");
        linkedList.insertLast("b");
        linkedList.insertLast("c");
        assertEquals("c", linkedList.deleteLast());
        assertEquals("b", linkedList.deleteLast());
        assertEquals("a", linkedList.deleteLast());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteFirstException() throws Exception {
        linkedList.deleteFirst();
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteLastException() throws Exception {
        linkedList.deleteLast();
    }

    @Test
    public void insertAtIllegalIndex() throws Exception {
        for (int illegal : ILLEGAL_INDICES) {
            try {
                linkedList.insertAtIndex(illegal, "test");
                fail("Insertion was not prevented at index " + illegal);
            }
            catch (IllegalArgumentException ignored) {
            }
        }

    }

    @Test
    public void deleteAtIllegalIndex() throws Exception {
        for (int illegal : ILLEGAL_INDICES) {
            try {
                linkedList.insertAtIndex(illegal, "test");
                fail("Deletion was not prevented at index " + illegal);
            }
            catch (IllegalArgumentException ignored) {
            }
        }
    }

    @Test
    public void insertDeleteAtIndex() throws Exception {
        linkedList.insertAtIndex(0, TEST);
        assertEquals(TEST, linkedList.deleteLast());

        linkedList.insertAtIndex(0, "c");
        linkedList.insertAtIndex(0, "a");
        linkedList.insertAtIndex(1, "b");
        assertEquals("b", linkedList.deleteFromIndex(1));
        assertEquals("c", linkedList.deleteFromIndex(1));
        assertEquals("a", linkedList.deleteFromIndex(0));
    }

}